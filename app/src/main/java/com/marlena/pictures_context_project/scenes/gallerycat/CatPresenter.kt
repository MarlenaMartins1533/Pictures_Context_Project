package com.marlena.pictures_context_project.scenes.gallerycat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import com.marlena.pictures_context_project.core.App
import com.marlena.pictures_context_project.dataSource.DataSourceFactory
import com.marlena.pictures_context_project.model.response.CatResponse

class CatPresenter(private val view: Cat.View) : Cat.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext get() = Dispatchers.Main
    private var job: Job? = null
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isLoading.value = true
    }

    val catList: LiveData<PagedList<CatResponse>> =
        LivePagedListBuilder<Int, CatResponse>(DataSourceFactory(), 10)
            .setBoundaryCallback(object : PagedList.BoundaryCallback<CatResponse>() {
                override fun onZeroItemsLoaded() {
                    super.onZeroItemsLoaded()
                    isLoading.value = false
                }

                override fun onItemAtFrontLoaded(itemAtFront: CatResponse) {
                    super.onItemAtFrontLoaded(itemAtFront)
                    isLoading.value = false
                }

                override fun onItemAtEndLoaded(itemAtEnd: CatResponse) {
                    super.onItemAtEndLoaded(itemAtEnd)
                    isLoading.value = false
                }
            })
            .build()

    override fun getCatsList() {
        job = launch {

            val result = withContext(Dispatchers.IO) {
                App.catRepository.getCatList()
            }

            if (result.isNullOrEmpty()) view.displayFailure(1)
            else view.setAllList(result)
        }
    }

    override fun kill() {
        job?.cancel()
    }
}