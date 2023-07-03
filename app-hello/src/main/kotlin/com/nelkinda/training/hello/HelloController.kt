package com.nelkinda.training.hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class HelloController(
    @Autowired private val helloService: HelloService
) {
    @GetMapping("/hello")
    fun hello() = helloService.hello()
}
