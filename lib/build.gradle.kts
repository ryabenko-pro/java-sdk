import org.gradle.jvm.tasks.Jar

group = "com.elarian"
version = "0.0.0"

plugins {
    `maven-publish`
    kotlin("jvm") version "1.3.72"
}

repositories {
    jcenter() 
}

dependencies {
    implementation(kotlin("stdlib")) 
    testImplementation("junit:junit:4.12")
}

publishing {
    publications {
        create<MavenPublication>("default") { 
            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("$buildDir/repository") 
        }
    }
}

