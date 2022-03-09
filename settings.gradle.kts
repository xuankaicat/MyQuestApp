pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    
}
rootProject.name = "MyQuestApp"

include(":android")
include(":desktop")
include(":web")
include(":common:compose-ui")
include(":common:database")
include(":common:main")
include(":common:router")
include(":common:utils")