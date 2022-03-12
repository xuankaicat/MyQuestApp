plugins {
    `multiplatform-setup`
    `android-setup`
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:utils"))
                implementation(project(":common:database"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.Badoo.Reaktive.reaktive)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtensionsCoroutines)
                implementation(Deps.KotlinX.coroutines)
            }
        }

        named("commonTest") {
            dependencies {
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
                implementation(Deps.KotlinX.coroutinesTest)
            }
        }
    }
}