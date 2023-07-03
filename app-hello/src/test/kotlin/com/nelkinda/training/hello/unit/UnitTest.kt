package com.nelkinda.training.hello.unit

import com.nelkinda.training.hello.Hello
import com.nelkinda.training.hello.HelloRepository
import com.nelkinda.training.hello.HelloService
import io.cucumber.java.Before
import io.cucumber.java.en.Then
import io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@CucumberContextConfiguration
@ConfigurationParameter(
    key = GLUE_PROPERTY_NAME,
    value = "com.nelkinda.training.hello.unit",
)
class UnitTest {
    private val helloRepository = mock<HelloRepository>()
    private val helloService = HelloService(helloRepository)

    @Before
    fun setup() {
        whenever(helloRepository.getReferenceById(1)).thenReturn(Hello(1, "Hello, world!"))
    }
    @Then("prints {string}")
    fun prints(string: String) {
        assertEquals(string, helloService.hello())
    }
}
