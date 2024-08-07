pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Sqwads"
include(":app")
include(":feature:lineups")
include(":core:design")
include(":core:data")
include(":core:common")
include(":feature:auctions")
include(":feature:profile")
include(":feature:auth")
include(":core:testing")
