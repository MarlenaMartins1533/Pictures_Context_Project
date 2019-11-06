package com.marlena.pictures_context_project.ui

import androidx.annotation.DrawableRes

data class PictureModel (
    @DrawableRes val image_drawable: Int,
    val id: Int,
    val name: String = ""
)