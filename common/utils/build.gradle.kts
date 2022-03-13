plugins {
    `multiplatform-compose-setup`
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

                // https://mvnrepository.com/artifact/de.rototor.jeuclid/jeuclid-core
                implementation("de.rototor.jeuclid:jeuclid-core:3.1.14")
            }
        }
    }
}
