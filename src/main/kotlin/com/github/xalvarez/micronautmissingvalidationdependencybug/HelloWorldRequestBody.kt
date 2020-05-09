package com.github.xalvarez.micronautmissingvalidationdependencybug

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Introspected
data class HelloWorldRequestBody(
        @field:NotBlank @field:Email val email: String = ""
)
