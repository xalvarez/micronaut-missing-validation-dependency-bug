package com.github.xalvarez.micronautmissingvalidationdependencybug

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.github.xalvarez.micronautmissingvalidationdependencybug")
                .mainClass(Application.javaClass)
                .start()
    }
}