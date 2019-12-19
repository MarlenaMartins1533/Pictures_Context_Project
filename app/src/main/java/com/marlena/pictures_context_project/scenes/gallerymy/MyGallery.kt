package com.marlena.pictures_context_project.scenes.gallerymy

import com.marlena.pictures_context_project.model.domain.ThePicture

interface MyGallery {
    interface View {
        fun setAllList(list: List<ThePicture>)
    }

    interface Presenter {
        fun getAllList()
        fun kill()
    }
}