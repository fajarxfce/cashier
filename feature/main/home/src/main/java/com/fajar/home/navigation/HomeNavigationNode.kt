package com.fajar.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.dialog
import androidx.navigation.fragment.fragment
import androidx.navigation.navigation
import com.fajar.home.fragment.AddTaskDialogFragment
import com.fajar.home.fragment.HomeScreenFragment
import com.fajar.home.fragment.TaskDetailDialogFragment
import com.fajar.navigation.NavigationNode
import javax.inject.Inject

class HomeNavigationNode @Inject constructor() : NavigationNode {

    override fun addNode(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.apply {
            navigation(startDestination = START_DESTINATION, route = ROUTE) {
                fragment<HomeScreenFragment>(START_DESTINATION)
                dialog<AddTaskDialogFragment>(ADD_TASK_DIALOG)
                dialog<com.fajar.home.fragment.TaskDetailDialogFragment>(TASK_DETAILS_DIALOG)
            }
        }
    }

    companion object {
        const val ROUTE = "home_route"
        const val START_DESTINATION = "home_screen"
        const val ADD_TASK_DIALOG = "add_task_dialog"
        const val TASK_DETAILS_DIALOG = "task_details_dialog"
    }
}