package com.marlena.pictures_context_project.service.themovidbapi

import android.util.Log
import com.marlena.pictures_context_project.data.Constants
import com.marlena.pictures_context_project.model.response.MovieResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MovieClient {

    private lateinit var movieApi: MovieApi

    fun callGetMovies(): MovieResponse? {
        val call = movieApi.getMovies()
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                Log.d("LENA", "getMovies successful: ${response.body()?.toString()}")
                return response.body()
            } else {
                Log.d("LENA", "getMovies Response Error: ${response.errorBody()?.toString()}")
            }
        } catch (e: IOException) {
            Log.e("IOException", e.message)
        } catch (e: RuntimeException) {
            Log.e("Runtime Exception", e.message)
        }
        return null
    }

    companion object {
        lateinit var instance: MovieClient
            private set

        fun initialize() {
            instance =
                MovieClient()
            instance.movieApi = Retrofit.Builder()
                .baseUrl(Constants.baseUrlMovie)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApi::class.java)
        }
    }
}