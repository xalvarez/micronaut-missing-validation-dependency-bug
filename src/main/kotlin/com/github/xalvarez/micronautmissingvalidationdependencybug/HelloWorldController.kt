package com.github.xalvarez.micronautmissingvalidationdependencybug

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_FORM_URLENCODED
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.validation.Valid

@Controller
open class HelloWorldController {

    @Post
    @Consumes(APPLICATION_FORM_URLENCODED)
    open fun hello(@Valid @Body helloWorldRequestBody: HelloWorldRequestBody): HttpResponse<Any>
            = HttpResponse.ok("""{"hello": "${helloWorldRequestBody.email}"}""")

}