import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.gradle.DokkaPlugin

plugins {
    kotlin("multiplatform") version "2.1.0" apply false
    id("com.android.library") version "8.7.2" apply false
    id("org.jetbrains.dokka") version "2.0.0"

    `maven-publish`
    jacoco
}

allprojects {
    group = "xyz.calcugames.koma"
    version = "0.1.0"
    description = "Kotlin Multiplatform Mathematics Library"

    repositories {
        mavenCentral()
        mavenLocal()
        google()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")
    apply(plugin = "maven-publish")
    apply<DokkaPlugin>()
}

tasks {
    withType<DokkaMultiModuleTask> {
        outputDirectory = layout.buildDirectory.dir("dokka")
    }
}