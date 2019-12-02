package com.marlena.pictures_context_project.ui.scenes.gallerycat

import com.marlena.pictures_context_project.ui.core.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class CatPresenter(private val view: Cat.View): Cat.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun getCatsList(){
        launch {
            val result = withContext(Dispatchers.IO) {
                App.pictureRepository.getCatsList()
            }
            if (result.isNullOrEmpty()) view.displayFailure(1)
            else view.setAllList(result)
        }
    }
}