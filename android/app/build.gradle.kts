plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.kapt")
    id("com.google.protobuf") version "0.9.4"
}

android {
    namespace = "dev.alexrodrigues.labs_csd_228"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.alexrodrigues.labs_csd_228"
        minSdk = 35
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
        languageVersion = "1.9"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.material3)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.activity.compose.v172)
    implementation(libs.androidx.ui.test.junit4)
    implementation(libs.androidx.navigation.compose.v240alpha10)
    implementation(libs.androidx.navigation.testing)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.runner)
    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.core.ktx.v1100)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.datastore.preferences.v100)
    implementation(libs.androidx.datastore)
    implementation(libs.protobuf.kotlin.lite)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    kapt("androidx.room:room-compiler:2.6.1")
    testImplementation (libs.mockito.core.v4110)
    testImplementation (libs.mockito.inline)

    testFixtures(libs.junit)

    testImplementation(libs.junit)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.mockito.core.v4110)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.byte.buddy)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.core)
    testImplementation(libs.androidx.junit.v121)
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.junit.v113)
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.androidx.ui.test.junit4.vversion)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    debugImplementation(libs.androidx.ui.test.manifest.vversion)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.7"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("kotlin") {
                    option("lite")
                }
                create("java") {
                    option("lite")
                }
            }
        }
    }
}