plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.estoquetoc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.estoquetoc"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation ("androidx.compose.ui:ui:1.5.0")
    implementation ("androidx.compose.material3:material3:1.1.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation ("androidx.activity:activity-compose:1.8.0")


    implementation("io.coil-kt:coil-compose:2.0.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Jetpack Compose libraries
    implementation(platform(libs.androidx.compose.bom)) // Compose BOM (Bill of Materials)
    implementation(libs.androidx.ui)                     // UI core components
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)      // Preview support
    implementation(libs.androidx.activity.compose)        // Activity with Compose

    // Material 3 components for Compose
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)

    // Navigation in Compose
    implementation(libs.androidx.navigation.compose)

    // Coil for image loading in Compose
    implementation(libs.coil.kt.coil.compose)

    // WebView
    implementation (libs.androidx.webkit.v140)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debugging tools
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

// Versões extras de dependências podem ser incluídas no "libs.versions.toml" ou em um arquivo equivalente
