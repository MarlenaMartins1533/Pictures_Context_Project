package com.marlena.pictures_context_project.ui.datasource
//
//import android.util.Log
//import androidx.paging.PageKeyedDataSource
//import com.marlena.pictures_context_project.ui.data.Constants
//import com.marlena.pictures_context_project.ui.model.CatResponse
//import com.marlena.pictures_context_project.ui.service.thecatapi.TheCatApi
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class CatDataSource : PageKeyedDataSource<Int, CatResponse>() {
//
//    companion object { //singleton - only one instance
//        lateinit var instance: CatDataSource
//            private set
//
//        fun initialize() {
//            instance = CatDataSource()
//            instance.theCatApi = Retrofit.Builder()
//                .baseUrlCat(Constants.baseUrlCat)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(TheCatApi::class.java)
//        }
//    }
//
//    private lateinit var theCatApi: TheCatApi
//    var nextPage = -1
//
//    override fun loadInitial(
//        params: LoadInitialParams<Int>,
//        callback: LoadInitialCallback<Int, CatResponse>
//    ) {
//        val response = call.execute()
//        call.enqueue(object : Callback<List<CatResponse>?> {
//            override fun onFailure(call: Call<List<CatResponse>?>, t: Throwable) {}
//
//            override fun onResponse(
//                call: Call<List<CatResponse>?>,
//                response: Response<List<CatResponse>?>
//            ) {
//                response.body()?.let {
//                    callback.onResult(it, null, nextPage)
//                }
//            }
//            })
//        }
//
//    override fun loadAfter(
//        params: LoadParams<Int>,
//        callback: LoadCallback<Int, CatResponse>
//    ) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun loadBefore(
//        params: LoadParams<Int>,
//        callback: LoadCallback<Int, CatResponse>
//    ) {
//    }
//}