package com.example.seminartensolution.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.seminartensolution.data.MovieRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.seminartensolution.R
import com.example.seminartensolution.data.MyResponse


class MovieViewModel : ViewModel() {

    sealed class DeleteResponseState {
        data class Success(val myResponse: MyResponse) : DeleteResponseState()
        data class Error(val errorMsg: String) : DeleteResponseState()
    }

    var movieId by mutableStateOf<String>("")
    var deleteResponseState by mutableStateOf<DeleteResponseState?>(null)
        private set

    init {

    }

    fun deleteMovieById(movieId: String) {
        viewModelScope.launch {
            val repository = MovieRepository()

            val id = movieId.toIntOrNull()
            if (id != null) {
                try {
                    val response = repository.deleteMovieById(id)
                    Log.d("DeleteResponseMessage: ", response.message)
                    deleteResponseState = DeleteResponseState.Success(response)
                } catch (e: Exception ) {
                    if (e.message != null) {
                        deleteResponseState = DeleteResponseState.Error(e.message!!)
                    } else {
                        deleteResponseState = null
                    }
                }

            } else {
                Log.e("DeleteError", "Invalid movie ID")
            }
        }
    }
}
