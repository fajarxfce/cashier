package com.fajar.home.fragment.adapter

import com.fajar.model.Task

interface HomeAdapterEvent {

    fun addTask()

    fun editTask(task: Task)

    fun toggleChecked(task: Task)

    fun detail(task: Task)
}