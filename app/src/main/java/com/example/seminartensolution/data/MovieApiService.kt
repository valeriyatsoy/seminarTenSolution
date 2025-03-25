package com.example.seminartensolution.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.DELETE
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL =
    "https://wiutmadcw.uz/api/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface MovieApiService {
    @DELETE("records/{record_id}")
    suspend fun deleteMovieById(
        @Path("record_id") movieId: Int,
        @Query("student_id") student_id: String
    ): MyResponse
}

object MovieApi {
    val retrofitService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}