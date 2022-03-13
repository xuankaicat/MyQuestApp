plugins {
    `multiplatform-compose-setup`
    `android-setup`
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:router"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.Decompose.extensionsCompose)

                // https://mvnrepository.com/artifact/de.rototor.jeuclid/jeuclid-core
                implementation("de.rototor.jeuclid:jeuclid-core:3.1.14")
            }
        }
    }
}
