package com.marlena.pictures_context_project.ui.scenes.gallery_landscape

import com.marlena.pictures_context_project.ui.Picture

interface Landscape {
    interface View{}
    interface Presenter{
        fun getAllList(): ArrayList<Picture>
    }
}