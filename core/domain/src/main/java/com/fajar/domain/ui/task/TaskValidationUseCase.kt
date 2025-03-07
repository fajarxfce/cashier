package com.fajar.domain.ui.task

import com.fajar.domain.ValidationResult

interface TaskValidationUseCase {
    fun validateTitle(title: String): ValidationResult
}