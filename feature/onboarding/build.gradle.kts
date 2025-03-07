plugins {
    alias(libs.plugins.project.android.feature)
}

android {
    namespace = "com.fajar.feature.onboarding"

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":feature:main:communicator"))
}