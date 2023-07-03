package com.nelkinda.training.hello

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = RANDOM_PORT)
class HelloControllerTestRestTemplateTest(
    @LocalServerPort private val port: Int,
    @Autowired private val testRestTemplate: TestRestTemplate,
) {
    @Test
    fun `returns hello message`() {
        val response = testRestTemplate.getForObject<String>("http://localhost:$port/api/v1/hello")
        assertThat(response).isEqualTo("Hello, world!")
    }
}
