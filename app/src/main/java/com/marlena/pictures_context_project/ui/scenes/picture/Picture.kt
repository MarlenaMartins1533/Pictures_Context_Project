package com.marlena.pictures_context_project.ui.scenes.picture

import com.marlena.pictures_context_project.ui.model.MyPicturesRoom

interface Picture {
    interface View {
        fun showMessage(message: String)
    }
    interface Presenter {
        fun insertMyPicture(myPicture: MyPicturesRoom)
        fun deleteMyPicture(myPicture: MyPicturesRoom)
        fun requestMessage(myPicture: MyPicturesRoom)
    }
}