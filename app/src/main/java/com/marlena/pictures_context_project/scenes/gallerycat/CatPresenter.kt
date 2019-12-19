package com.marlena.pictures_context_project.scenes.gallerycat

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import com.marlena.pictures_context_project.core.App

class CatPresenter(private val view: Cat.View) : Cat.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext get() = Dispatchers.Main
    private var job: Job? = null

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