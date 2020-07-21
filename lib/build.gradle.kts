import org.gradle.jvm.tasks.Jar

group = "com.elarian"
version = "0.0.0"

val protobufVersion = "3.12.2"
val grpcKotlinVersion = "0.1.4"

plugins {
    `maven-publish`
    kotlin("jvm") version "1.3.72"
    id("com.google.protobuf") version "0.8.12"
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.12")
    }
}

repositories {
    jcenter() 
}

dependencies {
    implementation(kotlin("stdlib")) 
    testImplementation("junit:junit:4.12")

    implementation("io.grpc:grpc-kotlin-stub-lite:$grpcKotlinVersion")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }
    plugins {
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpcKotlinVersion"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpckt")
            }
        }
    }
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

