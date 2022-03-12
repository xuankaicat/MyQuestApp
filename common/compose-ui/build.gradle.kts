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
            }
        }
    }
}
