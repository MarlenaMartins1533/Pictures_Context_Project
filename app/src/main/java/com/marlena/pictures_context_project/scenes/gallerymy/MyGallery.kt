package com.marlena.pictures_context_project.scenes.gallerymy

import com.marlena.pictures_context_project.model.entity.MyPictureEntity

interface MyGallery {
    interface View {
        fun setAllList(list: List<MyPictureEntity>)
        fun removeMyPicture(url: String)
        fun showMessage(message: String)
        fun displayFailure(error: Int)
    }

    interface Presenter {
        fun getPicture(url: String): MyPictureEntity
        fun getAllList()
        fun deleteMyPicture(myPicture: MyPictureEntity)
        fun kill()
    }
}