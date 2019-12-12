package com.marlena.pictures_context_project.scenes.gallerymy

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import com.marlena.pictures_context_project.model.entity.MyPictureEntity
import com.marlena.pictures_context_project.persistence.MyPicturesDB

class MyGalleryPresenter(private val view: MyGallery.View): MyGallery.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main
    private var job: Job? = null

    override fun getPicture(url: String): MyPictureEntity {
        var myPicture = MyPictureEntity()

        job = launch {
            withContext(Dispatchers.IO) {
                myPicture = MyPicturesDB.instance.mypicturesDAO().getByUrl(url)
            }
        }
        return myPicture
    }

    override fun getAllList() {
        job = launch {
            val myPicturesList = ArrayList<MyPictureEntity>()

            withContext(Dispatchers.IO) {
                MyPicturesDB.instance.mypicturesDAO().getAllMyPictures().let {
                    myPicturesList.addAll(it)
                }
            }
            view.setAllList(myPicturesList)
        }
    }

    override fun deleteMyPicture(myPicture: MyPictureEntity) {
        job = launch(Dispatchers.IO) {
            MyPicturesDB.instance.mypicturesDAO().delete(myPicture)
        }
    }

    override fun kill() {
        job?.cancel()
    }
}