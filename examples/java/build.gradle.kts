plugins {
    application
    java
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":lib"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

application {
    mainClassName = "com.elarian.example.java.App"
}
