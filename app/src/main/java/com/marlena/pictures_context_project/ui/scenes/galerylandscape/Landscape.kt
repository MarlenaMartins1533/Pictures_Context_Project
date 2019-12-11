package com.marlena.pictures_context_project.ui.scenes.galerylandscape

import com.marlena.pictures_context_project.ui.model.ThePicture

interface Landscape {
    interface View{}
    interface Presenter{
        fun getAllList(): ArrayList<ThePicture>
    }
}