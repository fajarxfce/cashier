import com.fajar.app.ProjectBuildType

plugins {
    alias(libs.plugins.project.android.application)
    alias(libs.plugins.project.android.hilt)
    alias(libs.plugins.project.android.navigation)
}

android {
    namespace = "com.fajar.app"

    defaultConfig {
        applicationId = "com.fajar.app"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = ProjectBuildType.DEBUG.applicationIdSuffix
        }
        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = ProjectBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    val listExcludes = listOf(
        ":core",
        ":feature",
        ":feature:main",
        ":build-logic",
        ":app"
    )
    rootProject.subprojects.forEach { module ->
        if(module.path !in listExcludes) implementation(project(module.path))
    }
}