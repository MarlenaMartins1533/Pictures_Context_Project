package com.marlena.pictures_context_project.ui.scenes.gallerycat

import com.marlena.pictures_context_project.ui.core.App
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CatPresenter(private val view: Cat.View) : Cat.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main
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