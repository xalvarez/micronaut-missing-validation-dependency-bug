# Micronaut missing validation dependency bug

This sample project reproduces the bug described here:
[https://github.com/micronaut-projects/micronaut-core/issues/3201](https://github.com/micronaut-projects/micronaut-core/issues/3201)

The project was initially created as follows using micronaut 1.3.5:

    mn create-app -l kotlin -i

## Steps to reproduce the bug

Start the application:

    ./gradlew run

Call its only endpoint with invalid data:

    curl -iX POST localhost:8080 -d "email=myinvalidemail"

Despite the fact that `email` is annoted with `@Email`, Bean Validation isn't triggered and the service answers with a
200 and the following body:

    HTTP/1.1 200 OK
    Date: Sat, 9 May 2020 15:18:54 GMT
    content-type: application/json
    content-length: 27
    connection: keep-alive
    
    {"hello": "myinvalidemail"}

To fix it, go to [build.gradle](build.gradle), uncomment the line `implementation "io.micronaut:micronaut-validation"`
and run the application again:

    ./gradlew clean run

Now issue the same request as before:

    curl -iX POST localhost:8080 -d "email=myinvalidemail"

In this case, Bean Validation is correctly called and the result is a 400:

    HTTP/1.1 400 Bad Request
    Date: Sat, 9 May 2020 15:19:53 GMT
    content-type: application/json
    content-length: 127
    connection: close
    
    {"message":"helloWorldRequestBody.email: must be a well-formed email address","_links":{"self":{"href":"/","templated":false}}}