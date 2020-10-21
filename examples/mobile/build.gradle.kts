plugins {
    id("com.android.application")
}

repositories {
    google()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.1.0")

    implementation(project(":android"))
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.2"

    defaultConfig {
        applicationId = "com.elarian.example.android"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
