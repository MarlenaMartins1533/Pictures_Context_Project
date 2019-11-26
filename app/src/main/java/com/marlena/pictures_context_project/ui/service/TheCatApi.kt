package com.marlena.pictures_context_project.ui.service

import com.marlena.pictures_context_project.ui.data.Constants
import com.marlena.pictures_context_project.ui.model.PictureResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApi {
    @GET("v1/images/search")
    fun getCats(
        @Query("limit") limit: Int = 20,
        @Query("size") size: String = "full",
        @Query("api_key") api_key: String = Constants.appId
    ): Call<List<PictureResponse>?>
}
//    @GET("thePictureList") //pega a lista de raças
//    fun getBreeds(): Call<List<String>>
//
//    @GET("image/random")//Imagem aleatória de dog
//    fun getRandomDogImage(): Call<PictureResponse>
//
//    @GET("{breed}/images")//lista de imagens por raça
//    fun getImagesByBreed(@Path("breed")breed: String): Call<PictureResponse>
//
//    //esse é o que eu quero
//    @GET("thePictureList/{all}")//pega raça aleatória dá lista de imagens
//    fun handleGetBreed(@Path("all")all: String): Call<PictureResponse>
//}