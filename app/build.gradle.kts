plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.implementasiapi_10pplg1"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.implementasiapi_10pplg1"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Library dari libs.versions.toml
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit & Gson (API)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // RecyclerView (for displaying lists)
    implementation("androidx.recyclerview:recyclerview:1.3.1")

    // Glide (for displaying images)
    implementation("com.github.bumptech.glide:glide:4.12.0")  // Updated version to 4.12.0
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")  // Use the same version for the compiler

    // CardView (for displaying card-based UI)
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.squareup.picasso:picasso:2.8")
}
