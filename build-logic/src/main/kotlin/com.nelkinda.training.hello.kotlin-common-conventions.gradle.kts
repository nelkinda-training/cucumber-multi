plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm")
    jacoco
    id("info.solidsoft.pitest")
}

repositories {
    mavenCentral()
}

dependencies {
    constraints {
        implementation("org.apache.commons:commons-text:1.10.0")
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.9.1")
        }
    }
}

pitest {
    targetClasses.set(listOf("com.nelkinda.training.hello.*"))
    outputFormats.set(listOf("XML", "HTML"))
    threads.set(1)
    pitestVersion.set("1.14.2")
    junit5PluginVersion.set("1.2.0")
}
