package com.marlena.pictures_context_project.ui.scenes.galeryanimal

import com.marlena.pictures_context_project.ui.model.ThePicture

interface Animal {

    interface View{
        fun setAllList(list: List<ThePicture>)
        fun displayFailure(error: Int)
    }
    interface Presenter{
        fun getCatsList()
//                : List<ThePicture>
    }
}