plugins {
    application
    kotlin("jvm") version "1.3.72"
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":jvm"))
}

application {
    mainClassName = "com.elarian.example.kotlin.AppKt"
}
