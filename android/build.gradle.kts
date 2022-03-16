plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

dependencies {
    implementation(project(":common:utils"))
    implementation(project(":common:database"))
    implementation(project(":common:router"))
    implementation(project(":common:compose-ui"))
    implementation(Deps.AndroidX.activity)
    implementation(Deps.AndroidX.appcompat)
    implementation(compose.material)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinLogging)
    implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinTimeTravel)
    implementation(Deps.ArkIvanov.Decompose.decompose)
    implementation(Deps.ArkIvanov.Decompose.extensionsCompose)
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.github.xuankaicat.android"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}