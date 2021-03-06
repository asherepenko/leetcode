import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    application
    id("org.jlleitschuh.gradle.ktlint") version "9.4.0"
    kotlin("jvm") version "1.4.10"
}

group = "com.sherepenko.leetcode"
description = "LeetCode challanges"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClassName = "com.sherepenko.leetcode.MainKt"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

ktlint {
    verbose.set(true)

    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
