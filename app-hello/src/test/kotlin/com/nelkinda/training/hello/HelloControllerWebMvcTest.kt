package com.nelkinda.training.hello

import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@MockBean(HelloService::class)
@WebMvcTest
class HelloControllerWebMvcTest(
    @Autowired private val mockMvc: MockMvc,
    @Autowired private val helloService: HelloService,
) {
    @Test
    fun test() {
        `when`(helloService.hello()).thenReturn("Hello, world!")
        mockMvc.perform(get("/api/v1/hello")).andExpect(status().isOk())
            .andExpect(content().string("Hello, world!"))
    }
}
