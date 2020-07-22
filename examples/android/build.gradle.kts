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

    implementation(project(":sdk-android"))
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        applicationId = "com.elarian.example.android"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_7
        targetCompatibility = JavaVersion.VERSION_1_7
    }
}
