package com.fajar.home.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fajar.common.data.asResult
import com.fajar.common.base.BaseState
import com.fajar.common.base.BaseViewModel
import com.fajar.common.data.DataResource
import com.fajar.common.data.resultResource
import com.fajar.common.util.Event
import com.fajar.domain.ValidationResult
import com.fajar.domain.tasks.GetTasksUseCase
import com.fajar.domain.ui.task.TaskValidationUseCase
import com.fajar.home.fragment.adapter.TaskListAdapterItem
import com.fajar.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetTasksUseCase,
    private val validationUseCase: TaskValidationUseCase
) : BaseViewModel() {

    private val _validationLiveData = MutableLiveData<Event<ValidationResult>>()
    val validationLiveData: LiveData<Event<ValidationResult>> = _validationLiveData

    private val _insertResultLiveData = MutableLiveData<Event<Boolean>>()
    val insertResultLiveData: LiveData<Event<Boolean>> = _insertResultLiveData

    val homeState = useCase.getTasks().asResult().map { result ->
        when(result) {
            is DataResource.Loading -> {
                BaseState(isLoading = true)
            }
            is DataResource.Success -> {
                BaseState(isLoading = false, data = result.data)
            }
            is DataResource.Error -> {
                BaseState(isLoading = false, data = null, error = result.exception?.toString() ?: "")
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = BaseState(isLoading = true)
    )

    fun insertTaskWithFieldsValidation(task: Task) {
        val result = validationUseCase.validateTitle(task.title)
        if (result.successful) {
            useCase.insertTask(task)
            _insertResultLiveData.value = Event(true)
        } else {
            _validationLiveData.value = Event(result)
        }
    }

    fun insertTask(task: Task) {
        useCase.insertTask(task)
    }

    fun updateTask(task: Task) {
        useCase.updateTask(task)
    }

    fun deleteTask(task: Task) {
        useCase.deleteTask(task)
    }

    fun generateHomeAdapterList(list: List<Task>): List<TaskListAdapterItem> {
        val array: MutableList<TaskListAdapterItem> = mutableListOf()
        if (list.isEmpty()) {
            array.add(TaskListAdapterItem.EmptyItem())
        } else {
            list.forEach { array.add(TaskListAdapterItem.TaskItem(it)) }
        }
        return array
    }

}