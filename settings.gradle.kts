pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven("https://mirrors.aliyun.com/maven/")// 阿里云 Maven 仓库
        maven("https://repo.maven.apache.org/maven2") // Maven 中央仓库
        maven("https://repo.huaweicloud.com/repository/maven/") // 华为 Maven 仓库 1
        maven("https://mirrors.huaweicloud.com/repository/maven/") // 华为 Maven 仓库 2
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven("https://mirrors.aliyun.com/maven/")// 阿里云 Maven 仓库
        maven("https://repo.huaweicloud.com/repository/maven/") // 华为 Maven 仓库 1
        maven("https://mirrors.huaweicloud.com/repository/maven/") // 华为 Maven 仓库 2
        mavenCentral()
    }
}

rootProject.name = "巧用Gradle构建Android应用"
include(":app")
include(":myandroidapp")
