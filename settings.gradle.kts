rootProject.name = "koma"

listOf(
    "core",
    "eval"
).forEach {
    include(":koma-$it")
    project(":koma-$it").projectDir = rootDir.resolve(it)
}

pluginManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
    }
}