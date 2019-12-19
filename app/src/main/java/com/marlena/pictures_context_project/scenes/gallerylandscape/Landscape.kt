package com.marlena.pictures_context_project.scenes.gallerylandscape

import com.marlena.pictures_context_project.model.domain.ThePicture

interface Landscape {
    interface View {
        fun setAllList(list: List<ThePicture>)
        fun displayFailure(error: Int)
    }

    interface Presenter {
        fun getAllList()
    }
}