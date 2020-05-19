plugins {
    application
    kotlin("jvm") version "1.3.72"
}

group = "com.sherepenko.leetcode"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClassName = "com.sherepenko.leetcode.MainKt"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}