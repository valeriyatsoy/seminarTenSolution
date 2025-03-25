package com.example.seminartensolution.data

import android.util.Log

class MovieRepository {
    suspend fun deleteMovieById(movieId: Int): MyResponse {
        val myResponse = MovieApi.retrofitService.deleteMovieById(movieId, "00001428")
        Log.d("myResponse message: ", myResponse.message)

        return myResponse
    }
}