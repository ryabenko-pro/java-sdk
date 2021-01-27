plugins {
    application
    kotlin("jvm") version "1.4.0"
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":jvm"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.0-M1")
}

application {
    mainClassName = "com.elarian.example.kotlin.AppKt"
}
