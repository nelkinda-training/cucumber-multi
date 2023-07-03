package com.nelkinda.training.hello.integration

import com.nelkinda.training.hello.HelloApplication
import io.cucumber.java.en.Then
import io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME
import io.cucumber.spring.CucumberContextConfiguration
import org.assertj.core.api.Assertions
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.boot.test.web.server.LocalServerPort

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@CucumberContextConfiguration
@SpringBootTest(classes = [HelloApplication::class], webEnvironment = RANDOM_PORT)
@ConfigurationParameter(
    key = GLUE_PROPERTY_NAME,
    value = "com.nelkinda.training.hello.integration",
)
class IntegrationTest(
    @LocalServerPort private val port: Int,
    @Autowired private val testRestTemplate: TestRestTemplate,
) {
    @Then("prints {string}")
    fun prints(string: String) {
        val response = testRestTemplate.getForObject<String>("http://localhost:$port/api/v1/hello")
        Assertions.assertThat(response).isEqualTo("Hello, world!")
    }
}
