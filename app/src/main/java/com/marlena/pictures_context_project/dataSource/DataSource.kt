package com.marlena.pictures_context_project.dataSource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.marlena.pictures_context_project.core.App
import com.marlena.pictures_context_project.model.response.CatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class CatDataSource : PageKeyedDataSource<Int, CatResponse>() {

    private var newPage = -1

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CatResponse>
    ) {
        newPage++
        val call = App.catRepository.getCatList(params)
        try {
            val response = call.execute(params.requestedLoadSize)
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
        call.enqueue(object : Callback<List<CatResponse>?>{
            override fun onFailure(call: Call<List<CatResponse>?>, t: Throwable) {}

            override fun onResponse(
                call: Call<List<CatResponse>?>,
                response: Response<List<CatResponse>?>
            ) {
                response.body()?.let {
                    callback.onResult(it, null, newPage)
                }
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CatResponse>) {
        newPage++
        val call = ApiService().getService().handleGetCats(params.requestedLoadSize)
        call.enqueue(object : Callback<List<CatResponse>?>{
            override fun onFailure(call: Call<List<CatResponse>?>, t: Throwable) {}

            override fun onResponse(
                call: Call<List<CatResponse>?>,
                response: Response<List<CatResponse>?>
            ) {
                response.body()?.let {
                    callback.onResult(it, newPage)
                }
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CatResponse>) {}

}