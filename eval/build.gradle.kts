import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id("com.android.library")
}

description = "Evaluation Engine for Koma"

kotlin {
    withSourcesJar()

    jvm {
        compilations.all {
            compileJavaTaskProvider?.configure {
                sourceCompatibility = "17"
                targetCompatibility = "17"
            }
        }
    }
    js {
        browser {
            testTask {
                useMocha {
                    timeout = "10m"
                }
            }

            useCommonJs()
        }
        nodejs {
            testTask {
                useMocha {
                    timeout = "10m"
                }
            }

            useCommonJs()
        }

        binaries.executable()
        generateTypeScriptDefinitions()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            testTask {
                useMocha {
                    timeout = "10m"
                }
            }
        }
        nodejs {
            testTask {
                useMocha {
                    timeout = "10m"
                }
            }

            useCommonJs()
        }


        binaries.executable()
        generateTypeScriptDefinitions()
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

    sourceSets {
        commonMain.dependencies {
            implementation(project(":koma-core"))
        }
    }
}

android {
    compileSdk = 34
    namespace = "xyz.calcugames.koma.eval"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}