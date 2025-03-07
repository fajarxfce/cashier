package com.fajar.domain

import com.fajar.common.ui.UiText

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: UiText? = null
)
