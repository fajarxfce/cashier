package com.fajar.common.data

import androidx.lifecycle.MutableLiveData
import com.fajar.common.base.BaseState
import com.fajar.common.util.handleOpt

fun <T> resultResource(result: DataResource<T>, state: MutableLiveData<BaseState<T>>) {
    when (result) {
        is DataResource.Loading -> {
            state.value = BaseState(isLoading = true)
        }

        is DataResource.Success -> {
            state.value = BaseState(isLoading = false, data = result.data)
        }

        is DataResource.Error -> {
            state.value = BaseState(
                error = result.exception.toString().handleOpt(),
                isLoading = false
            )
        }
    }
}