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

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}



dependencies {

    // ZXing para leitura de código de barras
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation("com.google.zxing:core:3.5.0")

    // Jetpack Compose e Material Design 3
    implementation(platform("androidx.compose:compose-bom:2024.02.00")) // Substitua pela versão atual do BOM
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.1") // Altere conforme sua versão do Jetpack Navigation

    // Coil para carregamento de imagens
    implementation("io.coil-kt:coil-compose:2.6.0")

    // Retrofit e OkHttp
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    implementation(libs.ui.text.google.fonts)
    implementation(libs.androidx.navigation.testing)
    implementation(libs.core)
    implementation(libs.androidx.junit.ktx)

    // Testes unitários
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.robolectric:robolectric:4.14")
    testImplementation("org.mockito:mockito-core:5.5.0") // Para mocks
    testImplementation("com.squareup.okhttp3:mockwebserver:4.11.0")
    testImplementation(libs.androidx.ui.test.junit4.android)

    // Testes instrumentados
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.7.5")
    androidTestImplementation("androidx.compose.ui:ui-test-manifest:1.7.5")

    // Ferramentas de depuração e testes de UI
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.5")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.7.5")

    // Animações
    implementation("androidx.compose.animation:animation:1.7.5")

    // Gson para serialização/deserialização JSON
    implementation("com.google.code.gson:gson:2.10.1")
}
