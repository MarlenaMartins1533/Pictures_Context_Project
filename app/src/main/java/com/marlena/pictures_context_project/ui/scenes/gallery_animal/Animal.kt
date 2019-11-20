package com.marlena.pictures_context_project.ui.scenes.gallery_animal

import com.marlena.pictures_context_project.ui.Picture

interface Animal {

    interface View{}

    interface Presenter{
        fun getAllList(): ArrayList<Picture>
    }
}