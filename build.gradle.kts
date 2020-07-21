buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.3")
    }
}

plugins {
    kotlin("jvm") version "1.3.72"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
