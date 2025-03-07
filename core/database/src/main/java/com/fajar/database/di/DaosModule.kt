package com.fajar.database.di

import com.fajar.database.TasksDatabase
import com.fajar.database.dao.TasksDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesTasksDao(
        database: TasksDatabase
    ): TasksDao = database.tasksDao()
}