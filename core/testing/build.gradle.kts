plugins {
    alias(libs.plugins.project.android.library)
    alias(libs.plugins.project.android.hilt)
}

android {
    namespace = "com.fajar.core.testing"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:domain"))

    api(libs.truth)
    api(libs.mockk)
    api(libs.androidx.core.testing)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)

    implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)

}