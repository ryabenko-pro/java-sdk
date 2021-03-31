plugins {
    application
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":elarian-core"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
}

application {
    mainClassName = "com.elarian.example.kotlin.AppKt"
}
