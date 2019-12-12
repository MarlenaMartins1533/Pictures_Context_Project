package com.marlena.pictures_context_project.scenes.picture

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import com.marlena.pictures_context_project.model.entity.MyPictureEntity
import com.marlena.pictures_context_project.persistence.MyPicturesDB

class PicturePresenter(private val view: Picture.View) : Picture.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main
    private var job: Job? = null

    override fun getPicture(url: String): MyPictureEntity {
        lateinit var myPicture: MyPictureEntity

        job = launch {
            withContext(Dispatchers.IO) {
                myPicture = MyPicturesDB.instance.mypicturesDAO().getByUrl(url)
            }
        }
        return myPicture
    }

    override fun requestMessage(message: String) {
        view.showMessage(message)
    }

    override fun insertMyPicture(myPicture: MyPictureEntity) {
        MyPicturesDB.instance.mypicturesDAO().insert(myPicture)
    }
}