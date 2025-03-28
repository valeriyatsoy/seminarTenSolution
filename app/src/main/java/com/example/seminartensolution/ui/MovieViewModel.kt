package com.example.seminartensolution.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.seminartensolution.data.MovieRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class MovieViewModel : ViewModel() {

    var movieIdInput by mutableStateOf<String>("")

    init {

    }

    fun deleteMovieById(movieId: String) {
        viewModelScope.launch {
            val repository = MovieRepository()

            val id = movieId.toIntOrNull()
            if (id != null) {
                val response = repository.deleteMovieById(id)
                Log.d("DeleteResponseMessage: ", response.message)
            } else {
                Log.e("DeleteError", "Invalid movie ID")
            }
        }
    }

}
