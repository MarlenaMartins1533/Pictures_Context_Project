package com.marlena.pictures_context_project.ui.service.thecatapi

import android.util.Log
import com.marlena.pictures_context_project.ui.data.Constants
import com.marlena.pictures_context_project.ui.model.CatResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class TheCatClient {

    private lateinit var theCatApi: TheCatApi

    fun callGetCats(): List<CatResponse>? {
        val call = theCatApi.getCats()
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                Log.d("LENA", "getCats successful: ${response.body()?.toString()}")
                return response.body()
            } else {
                Log.d("LENA", "getCats Response Error: ${response.errorBody()?.toString()}")
            }
        } catch (e: IOException) {
            Log.e("IOException", e.message)
        } catch (e: RuntimeException) {
            Log.e("Runtime Exception", e.message)
        }

        return null
    }

    companion object {
        lateinit var instance: TheCatClient
            private set

        fun initialize() {
            instance = TheCatClient()
            instance.theCatApi = Retrofit.Builder()
                .baseUrl(Constants.baseUrlCat)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TheCatApi::class.java)
        }
    }
}