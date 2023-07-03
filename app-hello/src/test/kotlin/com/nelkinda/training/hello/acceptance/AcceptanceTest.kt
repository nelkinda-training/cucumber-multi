package com.nelkinda.training.hello.acceptance

import com.nelkinda.training.hello.HelloApplication
import io.cucumber.java.en.Then
import io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@CucumberContextConfiguration
@SpringBootTest(classes = [HelloApplication::class], webEnvironment = RANDOM_PORT)
@ConfigurationParameter(
    key = GLUE_PROPERTY_NAME,
    value = "com.nelkinda.training.hello.acceptance",
)
class AcceptanceTest(
    @LocalServerPort private val localServerPort: Int,
) {
    @Then("prints {string}")
    fun prints(string: String) {
        println("Acceptance Test")
    }
}
