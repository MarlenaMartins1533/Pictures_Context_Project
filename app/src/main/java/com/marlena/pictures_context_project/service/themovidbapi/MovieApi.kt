package com.marlena.pictures_context_project.service.themovidbapi

import com.marlena.pictures_context_project.data.Constants
import com.marlena.pictures_context_project.model.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun getMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("api_key") appIdMovie: String = Constants.appIdMovie
    ): Call<MovieResponse>
}
