plugins {
    `multiplatform-setup`
    `android-setup`
    `kotlin-parcelize`
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:utils"))
                implementation(project(":common:database"))
                implementation(project(":common:main"))
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.KotlinX.coroutines)
            }
        }
    }
}