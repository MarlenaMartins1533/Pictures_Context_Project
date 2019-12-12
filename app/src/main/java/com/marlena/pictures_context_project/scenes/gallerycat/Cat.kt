package com.marlena.pictures_context_project.scenes.gallerycat

import com.marlena.pictures_context_project.model.domain.ThePicture

interface Cat {

    interface View {
        fun setAllList(list: List<ThePicture>)
        fun displayFailure(error: Int)
    }

    interface Presenter {
        fun getCatsList()
        fun kill()
    }
}