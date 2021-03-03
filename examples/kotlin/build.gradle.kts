plugins {
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":jvm"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.31")
}

application {
    mainClassName = "com.elarian.example.kotlin.AppKt"
}
