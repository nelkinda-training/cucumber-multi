package com.nelkinda.training.hello

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.boot.SpringApplication.exit
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class HelloApplicationSpringTest {
    @Test
    fun contextLoads() {
    }
}

class HelloApplicationMainTest {
    @Test
    fun mainRuns() {
        main()
        assertNotNull(appContext)
        exit(appContext)
    }
}
