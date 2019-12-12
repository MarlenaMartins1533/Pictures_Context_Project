package com.marlena.pictures_context_project.scenes.picture

import com.marlena.pictures_context_project.model.domain.ThePicture
import com.marlena.pictures_context_project.model.entity.MyPictureEntity

interface Picture {
    interface View {
        fun showMessage(message: String)
        fun getEdt(): String
        fun onBackPressed()
    }

    interface Presenter {
        fun insertMyPicture(thePicture: ThePicture)
        fun getMyPictureByUrl(url: String): MyPictureEntity?
    }
}