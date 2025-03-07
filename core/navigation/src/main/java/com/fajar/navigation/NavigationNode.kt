package com.fajar.navigation

import androidx.navigation.NavGraphBuilder

interface NavigationNode {
    fun addNode(navGraphBuilder: NavGraphBuilder)
}