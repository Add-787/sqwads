/**
 * Created by developer on 21-03-2025.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.noted.tasks

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.psyluckco.noted.R
import com.psyluckco.noted.data.model.Task
import com.psyluckco.noted.data.repository.TaskRepository
import com.psyluckco.noted.utils.Async
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * UiState for the tasks screen.
 */
data class TasksUiState(
    val tasks: List<Task> = emptyList(),
    val isRefreshing: Boolean = false,
    val userMessage: Int? = null
)

/**
 * ViewModel for the task list screen.
 */
@HiltViewModel
class TasksViewModel @Inject constructor(
    private val taskRepository: TaskRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _userMessage: MutableStateFlow<Int?> = MutableStateFlow(null)
    private val _isRefreshing = MutableStateFlow(false)
    private val _tasks = taskRepository.getTasksStream()
        .map { Async.Success(it) }
        .catch<Async<List<Task>>> { emit(Async.Error(R.string.placeholder)) }
}