plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.nagy.moviesapp"
    compileSdk = 35 // Target the latest SDK

    defaultConfig {
        applicationId = "com.nagy.moviesapp"
        minSdk = 26 // Minimum supported Android version
        targetSdk = 34 // Aligning with compileSdk
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
        sourceCompatibility = JavaVersion.VERSION_11 // Ensure compatibility with Java 11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11" // Use JVM 11 target
    }

    buildFeatures {
        viewBinding = true // Enable view binding
    }
}

dependencies {
    // Core Android libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material) // Material Design components
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // RecyclerView library (add if needed)
    implementation("androidx.recyclerview:recyclerview:1.3.1")

    // Unit testing
    testImplementation(libs.junit)

    // Android Instrumentation Testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
