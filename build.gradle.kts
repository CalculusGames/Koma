import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.gradle.DokkaPlugin

plugins {
    kotlin("multiplatform") version "2.1.10" apply false
    id("com.android.library") version "8.7.3" apply false
    id("org.jetbrains.dokka") version "2.0.0"
    id("com.vanniktech.maven.publish") version "0.30.0"

    `maven-publish`
    jacoco
    signing
}

allprojects {
    group = "xyz.calcugames.koma"
    val v = "0.1.0"
    version = if (project.hasProperty("snapshot")) "$v-SNAPSHOT" else v
    description = "Kotlin Multiplatform Mathematics Library"

    apply<SigningPlugin>()
    apply<DokkaPlugin>()
    apply(plugin = "com.vanniktech.maven.publish")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral()
        mavenLocal()
        google()
    }

    signing {
        val signingKey: String? by project
        val signingPassword: String? by project

        if (signingKey != null && signingPassword != null)
            useInMemoryPgpKeys(signingKey, signingPassword)

        sign(publishing.publications)
    }

    publishing {
        publications {
            filterIsInstance<MavenPublication>().forEach {
                it.apply {
                    pom {
                        name = "Koma"

                        licenses {
                            license {
                                name = "MIT License"
                                url = "https://opensource.org/licenses/MIT"
                            }
                        }

                        developers {
                            developer {
                                id = "gmitch215"
                                name = "Gregory Mitchell"
                                email = "gmitch215@calcugames.xyz"
                            }
                        }

                        scm {
                            connection = "scm:git:git://github.com/CalculusGames/Koma.git"
                            developerConnection = "scm:git:ssh://github.com/CalculusGames/Koma.git"
                            url = "https://github.com/CalculusGames/Koma"
                        }
                    }
                }
            }
        }

        repositories {
            maven {
                name = "CalculusGames"
                credentials {
                    username = System.getenv("NEXUS_USERNAME")
                    password = System.getenv("NEXUS_PASSWORD")
                }

                val releases = "https://repo.calcugames.xyz/repository/maven-releases/"
                val snapshots = "https://repo.calcugames.xyz/repository/maven-snapshots/"
                url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshots else releases)
            }

            if (!version.toString().endsWith("SNAPSHOT")) {
                maven {
                    name = "GithubPackages"
                    credentials {
                        username = System.getenv("GITHUB_ACTOR")
                        password = System.getenv("GITHUB_TOKEN")
                    }

                    url = uri("https://maven.pkg.github.com/CalculusGames/Koma")
                }
            }
        }
    }

    mavenPublishing {
        coordinates(project.group.toString(), project.name, project.version.toString())

        pom {
            name.set("Koma")
            description.set(project.description)
            url.set("https://github.com/CalculusGames/Koma")
            inceptionYear.set("2024")

            licenses {
                license {
                    name.set("MIT License")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }

            developers {
                developer {
                    id = "gmitch215"
                    name = "Gregory Mitchell"
                    email = "me@gmitch215.xyz"
                }
            }

            scm {
                connection = "scm:git:git://github.com/CalculusGames/Koma.git"
                developerConnection = "scm:git:ssh://github.com/CalculusGames/Koma.git"
                url = "https://github.com/CalculusGames/Koma"
            }
        }

        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
        signAllPublications()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")

    tasks {
        withType<Test> {
            useJUnitPlatform()

        }

        create("jvmJacocoTestReport", JacocoReport::class) {
            dependsOn("jvmTest")

            classDirectories.setFrom(layout.buildDirectory.file("classes/kotlin/jvm/"))
            sourceDirectories.setFrom("src/commonMain/kotlin/", "src/jvmMain/kotlin/")
            executionData.setFrom(layout.buildDirectory.files("jacoco/jvmTest.exec"))

            reports {
                xml.required.set(true)
                xml.outputLocation.set(layout.buildDirectory.file("jacoco.xml"))

                html.required.set(true)
                html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
            }
        }
    }

    dokka {
        moduleName.set(name)
        pluginsConfiguration.html {
            footerMessage.set("(c) Calculus Games")
        }
    }
}

dependencies {
    dokka(project(":koma-core"))
    dokka(project(":koma-eval"))
}