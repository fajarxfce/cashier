package com.fajar.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fajar.database.dao.TasksDao
import com.fajar.database.model.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 1
)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun tasksDao(): TasksDao
}