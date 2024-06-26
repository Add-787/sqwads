/**
 * Created by developer on 26-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.sqwads

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(

) : ViewModel() {
}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val user : String) : MainActivityUiState

}