import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id("com.android.library")
}

description = "Core API for Koma"

kotlin {
    jvm {
        compilations.all {
            compileJavaTaskProvider?.configure {
                sourceCompatibility = "11"
                targetCompatibility = "11"
            }
        }
    }
    js {
        browser {
            testTask {
                enabled = false
            }

            binaries.executable()
        }
        nodejs()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            testTask {
                enabled = false
            }

            binaries.executable()
        }
        nodejs()
    }

    mingwX64()
    linuxX64()
    linuxArm64()
    macosX64()
    macosArm64()

    androidTarget {
        publishAllLibraryVariants()
    }
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX64()
    androidNativeX86()

    iosX64()
    iosArm64()
    iosSimulatorArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()
    watchosDeviceArm64()
}

android {
    compileSdk = 33
    namespace = "xyz.calcugames.koma"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}