package com.marlena.pictures_context_project.ui.scenes.gallerycat

import com.marlena.pictures_context_project.ui.model.ThePicture

interface Cat {

    interface View{
        fun setAllList(list: List<ThePicture>)
        fun displayFailure(error: Int)
    }
    interface Presenter{
        fun getCatsList()
//                : List<ThePicture>
    }
}