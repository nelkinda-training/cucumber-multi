plugins {
    id("com.nelkinda.training.hello.kotlin-application-conventions")
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
}

dependencies {
    implementation(project(":utilities"))
    implementation("org.apache.commons:commons-text")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("com.h2database:h2")
    testImplementation("io.cucumber:cucumber-java:7.12.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.12.1")
    testImplementation("io.cucumber:cucumber-spring:7.12.1")
    testImplementation("org.junit.platform:junit-platform-suite:1.9.3")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.0.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

application {
    // Define the main class for the application.
    mainClass.set("com.nelkinda.training.hello.app.AppKt")
}
