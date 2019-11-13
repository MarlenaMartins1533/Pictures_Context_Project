package com.marlena.pictures_context_project.ui.repository

import com.marlena.pictures_context_project.ui.scenes.PictureResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PictureRepository {
    @GET("list")
    fun handleGetBreeads(): Call<List<String>>

    @GET("list/{all}")
    fun handleGetBreead(@Path("all")all: String): Call<PictureResponse>

    @GET("{breed}/images")
    fun getImagesByBreed(@Path("breed")breed: String): Call<PictureResponse>

    @GET("image/random")
    fun getRandomDogImage(): Call<PictureResponse>
}