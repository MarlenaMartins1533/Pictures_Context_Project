package com.marlena.pictures_context_project.model.domain

data class ThePicture(

    val url: String,
    val name: String = "Atenção",
    val favorite: Boolean = false,
    var sensation: String = ""
)