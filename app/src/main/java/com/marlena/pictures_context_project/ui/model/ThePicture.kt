package com.marlena.pictures_context_project.ui.model

data class ThePicture(

    val url: String,
    val name: String = "Atenção",
    val favorite: Boolean = false,
    val sensation: String =""
)