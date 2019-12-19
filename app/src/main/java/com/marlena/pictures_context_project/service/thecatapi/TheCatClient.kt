package com.marlena.pictures_context_project.service.thecatapi

import android.util.Log
import androidx.paging.PageKeyedDataSource
import retrofit2.Retrofit
import java.io.IOException
import retrofit2.converter.gson.GsonConverterFactory
import com.marlena.pictures_context_project.data.Constants
import com.marlena.pictures_context_project.model.response.CatResponse
import com.marlena.pictures_context_project.model.response.MovieResponse

class TheCatClient {

    private lateinit var theCatApi: TheCatApi

    fun callGetCats(params: LoadInitialParams<Int>): CatResponse? {
            val call = theCatApi.getCats(params)
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

//        val call = theCatApi.getCats()
//        try {
//            val response = call.execute()
//            if (response.isSuccessful) {
//                Log.d("LENA", "getCats successful: ${response.body()?.toString()}")
//                return response.body()
//            } else {
//                Log.d("LENA", "getCats Response Error: ${response.errorBody()?.toString()}")
//            }
//        } catch (e: IOException) {
//            Log.e("IOException", e.message)
//        } catch (e: RuntimeException) {
//            Log.e("Runtime Exception", e.message)
//        }
//
//        return null
    }

    companion object {
        lateinit var instance: TheCatClient
            private set

        fun initialize() {
            instance =
                TheCatClient()
            instance.theCatApi = Retrofit.Builder()
                .baseUrl(Constants.baseUrlCat)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TheCatApi::class.java)
        }
    }
}