plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.maxwayapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.maxwayapp"
        minSdk = 21
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //+998 uchun
//    implementation("com.github.santalu:mask-edittext:1.0.2")
    implementation ("io.github.vicmikhailau:MaskedEditText:5.0.1")

    // navgraph

    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.5")

    //viewbinding
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("com.github.kirich1409:viewbindingpropertydelegate-full:1.5.9")

    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.mikhaellopez:circularimageview:4.3.1")

    //database
    implementation ("androidx.room:room-runtime:2.6.1")

    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")

    implementation ("com.github.angads25:toggle:1.1.0")

    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //Picasso
    implementation("com.squareup.picasso:picasso:2.8")
//    implementation ("androidx.room:room-runtime:2.6.1")
//    kapt ("androidx.room:room-compiler:2.6.1")
//    implementation ("androidx.room:room-ktx:2.6.1")

    val room_version = ("2.4.1")

    implementation ("androidx.room:room-runtime:2.6.1")

    kapt ("androidx.room:room-compiler:2.6.1")

    // Kotlin support
    implementation ("androidx.room:room-ktx:2.6.1")

    // Test helpers
    testImplementation ("androidx.room:room-testing:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")

    implementation ("com.google.android.libraries.places:places:3.3.0")
    implementation ("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.android.libraries.places:places:3.3.0")



}

kapt {
    correctErrorTypes = true
}

