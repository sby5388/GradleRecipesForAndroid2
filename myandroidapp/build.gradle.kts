plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}
apply("param.gradle.kts")
apply("flavors.gradle.kts")
apply("custom.task.gradle.kts")

android {
    namespace = "com.shenby.grfa1"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.shenby.grfa1"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


        val keyP1 = project.extra["p1"]
        val keyP2 = project.extra["p2"]
        buildConfigField("String", "PARAM_P1", "\"$keyP1\"")
        buildConfigField("String", "PARAM_P2", "\"$keyP2\"")

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
//            applicationIdSuffix = ".debug"
//            applicationIdSuffix = ""
            versionNameSuffix = "-debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

//    flavorDimensions "attitude"
    flavorDimensions.addAll(listOf("api", "version"))

    productFlavors {
        create("arrogant") {
            dimension = "version"
        }
        create("friendly") {
            dimension = "version"
        }
        create("obsequious") {
            dimension = "version"
        }
        create("minApi24") {
            // Assigns this flavor to the 'api' dimension.
            dimension = "api"
            minSdk = 24
            versionNameSuffix = "-minApi24"
        }
        create("minApi26") {
            dimension = "api"
            minSdk = 26
            versionNameSuffix = "-minApi26"
        }

    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}