package com.fajar.home.navigation.di

import com.fajar.home.navigation.HomeNavigationNode
import com.fajar.navigation.NavigationNode
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
    fun bindNavigationNode(homeNavigationNode: HomeNavigationNode): NavigationNode
}