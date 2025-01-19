import org.jetbrains.kotlin.gradle.model.Kapt

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
}

android {
    namespace = "com.example.intern_reference_project"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.intern_reference_project"
        minSdk = 31
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.lifecycle.viewmodel.ktx) // For viewModelScope
    implementation(libs.lifecycle.runtime.ktx)   // Required for Lifecycle components
    implementation(libs.kotlin.coroutines.core) // Core coroutine library
    implementation(libs.kotlin.coroutines.android)
    implementation(libs.fragment.ktx) // For by viewModels support

}