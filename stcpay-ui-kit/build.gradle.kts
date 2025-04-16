plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.stcpay.uikit"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion  = libs.versions.composeCompiler.get()
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
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui)
    implementation(libs.compose.tooling)
    implementation(libs.compose.util)
    implementation(libs.compose.debugging)
    implementation(libs.compose.constraintLayout)

}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.stcpay"
            artifactId = "stcpay-uikit-android"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}