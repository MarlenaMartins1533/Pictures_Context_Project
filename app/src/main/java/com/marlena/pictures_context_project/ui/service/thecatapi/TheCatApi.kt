package com.marlena.pictures_context_project.ui.service.thecatapi

import com.marlena.pictures_context_project.ui.data.Constants
import com.marlena.pictures_context_project.ui.model.CatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApi {

    @GET("v1/images/search")
    fun getCats(
        @Query("limit") limit: Int = 20,
        @Query("size") size: String = "full",
        @Query("api_key") api_key: String = Constants.appIdCat
    ): Call<List<CatResponse>?>
}