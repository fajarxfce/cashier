package com.fajar.onboarding.navigation.di

import com.fajar.navigation.NavigationNode
import com.fajar.onboarding.navigation.OnboardingNavigationNode
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @IntoSet
    @Binds
    fun bindNavigationNode(onboardingNavigationNode: OnboardingNavigationNode): NavigationNode
}