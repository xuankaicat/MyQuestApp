plugins {
    `android-setup`
    `kotlin-android`
}

group = "com.github.gregcockroft"

android {
    sourceSets["main"].manifest.srcFile("src/main/AndroidManifest.xml")
    defaultConfig {
        externalNativeBuild {
            cmake {
                arguments.add("-Dcdep-dependencies_DIR=../../../.cdep/modules")
                //arguments.add("-DANDROID_STL=c++_shared")
            }
        }
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.10.2"
        }
    }

    sourceSets {
        named("main") {
            // let gradle pack the shared library into apk
            jniLibs.srcDirs("../distribution/gperf/lib")
        }
    }

    ndkVersion = "23.1.7779620"
}

dependencies {
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.appcompat)
    implementation("com.google.android.material:material:1.4.0")
    implementation("junit:junit:${Versions.junit}")
}