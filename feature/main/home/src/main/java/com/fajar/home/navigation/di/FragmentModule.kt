package com.fajar.home.navigation.di

import com.fajar.communicator.HomeFeatureCommunicator
import com.fajar.home.navigation.HomeFeatureCommunicatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface FragmentModule {

    @Binds
    fun bindCommunicator(homeFeatureCommunicatorImpl: HomeFeatureCommunicatorImpl): HomeFeatureCommunicator
}