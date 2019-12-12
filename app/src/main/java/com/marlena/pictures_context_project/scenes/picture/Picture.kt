package com.marlena.pictures_context_project.scenes.picture

import com.marlena.pictures_context_project.model.entity.MyPictureEntity

interface Picture {
    interface View {
        fun showMessage(message: String)
    }
    interface Presenter {
        fun getPicture(url: String): MyPictureEntity
        fun insertMyPicture(myPicture: MyPictureEntity)
        fun requestMessage(message: String)
    }
}