package com.fajar.domain.repository

import com.fajar.model.Task
import kotlinx.coroutines.flow.Flow

interface TasksRepository {

    fun insertTask(task: Task)
    fun deleteTask(task: Task)
    fun getTasks(): Flow<List<Task>>
    fun updateTask(task: Task)
}