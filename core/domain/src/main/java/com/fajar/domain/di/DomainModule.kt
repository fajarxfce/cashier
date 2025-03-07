package com.fajar.domain.di

import com.fajar.domain.tasks.GetTasksUseCase
import com.fajar.domain.tasks.GetTasksUseCaseImpl
import com.fajar.domain.ui.task.TaskValidationUseCase
import com.fajar.domain.ui.task.TaskValidationUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DomainModule {

    @Binds
    abstract fun bindGetTasksUseCase(tasksUseCaseImpl: GetTasksUseCaseImpl): GetTasksUseCase

    @Binds
    abstract fun bindValidationTaskUseCase(validationUseCase: TaskValidationUseCaseImpl): TaskValidationUseCase
}