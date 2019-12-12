package com.marlena.pictures_context_project.scenes.picture

import com.marlena.pictures_context_project.model.entity.MyPictureEntity
import com.marlena.pictures_context_project.persistence.MyPicturesDB

class PicturePresenter : Picture.Presenter {

    override fun insertMyPicture(url: String) {
        val myPicture: MyPictureEntity =  MyPicturesDB.instance.mypicturesDAO().getByUrl(url)
        MyPicturesDB.instance.mypicturesDAO().insert(myPicture)
    }
}