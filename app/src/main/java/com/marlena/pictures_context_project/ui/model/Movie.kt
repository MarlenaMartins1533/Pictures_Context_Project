package com.marlena.pictures_context_project.ui.model

import com.google.gson.annotations.SerializedName

data class Movie(
    //nome
    @SerializedName("title")
    val title: String,
    //url
    @SerializedName("poster_path")
    val poster_path: String
)