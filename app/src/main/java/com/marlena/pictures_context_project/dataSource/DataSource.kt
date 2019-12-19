package com.marlena.pictures_context_project.dataSource

import androidx.paging.PageKeyedDataSource
import com.marlena.pictures_context_project.core.App
import com.marlena.pictures_context_project.model.response.CatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class DataSource {
    private var newPage = -1

    var onScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            if (!lastPage && !recyclerView.canScrollVertically(1)) {
                requestNextPage()
            }
        }
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CatResponse>
    ) {
        newPage++
        val call = App.catRepository.getCatList(params.requestedLoadSize)
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CatResponse>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}