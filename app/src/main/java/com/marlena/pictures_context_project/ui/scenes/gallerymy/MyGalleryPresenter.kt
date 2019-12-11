package com.marlena.pictures_context_project.ui.scenes.gallerymy

import com.marlena.pictures_context_project.ui.model.ThePicture

class MyGalleryPresenter(private val view: MyGallery.View) : MyGallery.Presenter {

    lateinit var pictureList: ArrayList<ThePicture>

    override fun getAllList() {

        pictureList = arrayListOf( //temporário, tirar!
            ThePicture(
                url = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Flat_plus_icon.svg/1024px-Flat_plus_icon.svg.png",
                name = "Empty!"
            )
        )
        view.setAllList(pictureList)
    }
}