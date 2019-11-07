package com.marlena.pictures_context_project.ui

import androidx.annotation.DrawableRes

data class Picture (
    @DrawableRes val image_drawable: Int,
    val id: Int,
    val name: String = ""
)