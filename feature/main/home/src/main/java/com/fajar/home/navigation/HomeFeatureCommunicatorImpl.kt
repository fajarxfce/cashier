package com.fajar.home.navigation

import androidx.navigation.NavController
import com.fajar.communicator.HomeFeatureCommunicator
import com.fajar.navigation.navigateWithAnimation
import javax.inject.Inject

class HomeFeatureCommunicatorImpl @Inject constructor(private val navController: NavController): HomeFeatureCommunicator {

    override fun launchFeature(homeFeatureArgs: HomeFeatureCommunicator.HomeFeatureArgs) {
        navController.navigateWithAnimation(
            route = HomeNavigationNode.ROUTE,
            popUpTo = homeFeatureArgs.previousRoute,
            inclusive = true
        )
    }
}