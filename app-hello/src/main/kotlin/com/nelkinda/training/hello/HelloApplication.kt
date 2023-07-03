package com.nelkinda.training.hello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class HelloApplication

@get:Generated
internal lateinit var appContext: ApplicationContext
    private set

fun main(vararg args: String) {
    appContext = runApplication<HelloApplication>(*args)
}
