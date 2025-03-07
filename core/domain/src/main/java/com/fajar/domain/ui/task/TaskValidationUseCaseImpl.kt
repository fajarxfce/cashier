package com.fajar.domain.ui.task

import com.fajar.common.ui.UiText
import com.fajar.core.domain.R
import com.fajar.domain.ValidationResult
import javax.inject.Inject

class TaskValidationUseCaseImpl @Inject constructor() : TaskValidationUseCase {

    override fun validateTitle(title: String): ValidationResult {
        if (title.isEmpty()) {
            return ValidationResult(
                false, UiText.StringResource(R.string.title_cant_be_empty)
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}