plugins {
    `multiplatform-setup`
    `android-setup`
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(Deps.ArkIvanov.MVIKotlin.rx)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.Badoo.Reaktive.reaktive)
                implementation(Deps.KotlinX.coroutines)
            }
        }
    }
}
