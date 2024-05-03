import org.jetbrains.compose.internal.utils.getLocalProperty
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.23"
    id("com.codingfeline.buildkonfig") version "0.15.0"
    id("com.google.devtools.ksp") version "1.9.23-1.0.20"
    id("com.rickclephas.kmp.nativecoroutines") version "1.0.0-ALPHA-25"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    sourceSets {
        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
        }

        commonMain.dependencies {
            // put your Multiplatform dependencies here
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            implementation("io.ktor:ktor-client-core:2.3.3")
            implementation("io.ktor:ktor-client-content-negotiation:2.3.3")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
            implementation("io.github.xxfast:kstore:0.6.0")
            implementation("io.github.xxfast:kstore-file:0.6.0")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
        }

        androidMain.dependencies {
            implementation("androidx.startup:startup-runtime:1.2.0-alpha02")
            implementation("io.ktor:ktor-client-android:2.3.3")
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.3")
        }
    }
}

android {
    namespace = "com.jetbrains.weatherapp.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

buildkonfig {
    packageName = "com.jetbrains.weatherapp"
    objectName = "ApiKeyConfig"
    exposeObjectWithName = "Config"

    defaultConfigs {
        buildConfigField(
            com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING,
            "WeatherApiKey",
            getLocalProperty("WEATHER_API_KEY").toString()
        )
    }
}
