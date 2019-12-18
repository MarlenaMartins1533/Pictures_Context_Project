package com.marlena.pictures_context_project.scenes.gallerymy

import com.marlena.pictures_context_project.model.domain.ThePicture
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import com.marlena.pictures_context_project.model.entity.MyPictureEntity
import com.marlena.pictures_context_project.persistence.MyPicturesDB

class MyGalleryPresenter(private val view: MyGallery.View): MyGallery.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main
    private var job: Job? = null

    override fun getAllList() {
        job = launch {
            val myPicturesList = ArrayList<MyPictureEntity>()

            withContext(Dispatchers.IO) {
                MyPicturesDB.instance.mypicturesDAO().getAllMyPictures().let {
                    myPicturesList.addAll(it)
                }
            }
            val thePictureList = convertMyPicturesListInToDomain(myPicturesList)
            view.setAllList(thePictureList)
        }
    }

    private fun convertMyPicturesListInToDomain(
        myPictureList: MutableList<MyPictureEntity>
    ): List<ThePicture> {

        return myPictureList.map {
            ThePicture(
                name = it.name,
                url = it.url
            )
        }
    }

    override fun kill() {
        job?.cancel()
    }
}