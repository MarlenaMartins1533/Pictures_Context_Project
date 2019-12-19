package com.marlena.pictures_context_project.ui.scenes.gallerymy

import com.marlena.pictures_context_project.ui.model.ThePicture

interface MyGallery {
    interface View {
        fun setAllList(list: List<ThePicture>)
        fun displayFailure(error: Int)
    }

    interface Presenter {
        fun getAllList()
    }
}