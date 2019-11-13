package com.marlena.pictures_context_project.ui.service

import com.marlena.pictures_context_project.ui.repository.PictureRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breeds/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService() = retrofit.create(PictureRepository::class.java)
}