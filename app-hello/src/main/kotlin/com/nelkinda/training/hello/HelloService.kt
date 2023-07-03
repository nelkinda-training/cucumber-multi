package com.nelkinda.training.hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HelloService(
    @Autowired private val helloRepository: HelloRepository,
) {
    fun hello(): String = helloRepository.getReferenceById(1).message
}
