package com.nelkinda.training.hello

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class HelloRepositoryTest(
    @Autowired private val helloRepository: HelloRepository
) {
    @Test
    fun `hello is stored in the repository`() {
        assertEquals(Hello(1, "Hello, world!"), helloRepository.getReferenceById(1))
        assertEquals(1, helloRepository.getReferenceById(1).id)
    }
}
