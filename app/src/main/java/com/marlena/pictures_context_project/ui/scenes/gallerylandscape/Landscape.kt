package com.marlena.pictures_context_project.ui.scenes.gallerylandscape

import com.marlena.pictures_context_project.ui.model.ThePicture

interface Landscape {
    interface View {
        fun setAllList(list: List<ThePicture>)
        fun displayFailure(error: Int)
    }

    interface Presenter {
        fun getAllList()
    }
}