package com.fajar.data.model

import com.fajar.database.model.TaskEntity
import com.fajar.model.Task

fun Task.toEntity() = TaskEntity(
    uid, title, description, isChecked
)