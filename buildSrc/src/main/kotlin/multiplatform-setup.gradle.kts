plugins {
    id("com.android.library")
    id("kotlin-multiplatform")
}

kotlin {
    jvm("desktop")
    android()

    js(IR) {
        browser()
    }

    sourceSets {
        named("commonTest") {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        named("androidTest") {
            dependencies {
                implementation(kotlin("test"))
                implementation("junit:junit:${Versions.junit}")
            }
        }
        named("desktopTest") {
            dependencies {
                implementation(kotlin("test"))
                implementation("junit:junit:${Versions.junit}")
            }
        }
        named("jsTest") {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}
