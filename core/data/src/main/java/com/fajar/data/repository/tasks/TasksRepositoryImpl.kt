package com.fajar.data.repository.tasks

import com.fajar.data.model.toEntity
import com.fajar.database.BinDispatchers
import com.fajar.database.Dispatcher
import com.fajar.database.dao.TasksDao
import com.fajar.database.model.toExternalModel
import com.fajar.domain.repository.TasksRepository
import com.fajar.model.Task
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class TasksRepositoryImpl @Inject constructor(
    @Dispatcher(BinDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val tasksDao: TasksDao
) : TasksRepository {
    override fun insertTask(task: Task) {
        CoroutineScope(ioDispatcher).launch {
            tasksDao.insertTask(task.toEntity())
        }
    }

    override fun deleteTask(task: Task) {
        CoroutineScope(ioDispatcher).launch {
            tasksDao.deleteTask(task.toEntity())
        }
    }

    override fun getTasks(): Flow<List<Task>> =
        tasksDao.getTaskEntities().map { it.map { it.toExternalModel() } }.flowOn(ioDispatcher)

    override fun updateTask(task: Task) {
        CoroutineScope(ioDispatcher).launch {
            tasksDao.insertTask(task.toEntity())
        }
    }
}