package com.marlena.pictures_context_project.ui.scenes.galeryanimal

import com.marlena.pictures_context_project.ui.core.App
import com.marlena.pictures_context_project.ui.model.PictureResponse
import com.marlena.pictures_context_project.ui.model.ThePicture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class AnimalPresenter(private val view: Animal.View): Animal.Presenter, CoroutineScope {
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