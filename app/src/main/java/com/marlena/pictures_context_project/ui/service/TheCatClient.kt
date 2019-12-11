package com.marlena.pictures_context_project.ui.service

import android.util.Log
import com.marlena.pictures_context_project.ui.data.Constants
import com.marlena.pictures_context_project.ui.model.PictureResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class TheCatClient {
    companion object { //singleton - only one instance
        lateinit var instance: TheCatClient
            private set

        fun initialize() {
            instance = TheCatClient()
            instance.theCatApi = Retrofit.Builder()
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TheCatApi::class.java)
        }
    }

    private lateinit var theCatApi: TheCatApi

    fun callGetCats(): List<PictureResponse>? {
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
}
