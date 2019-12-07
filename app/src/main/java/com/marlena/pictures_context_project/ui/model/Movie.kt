package com.marlena.pictures_context_project.ui.model

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path")
    val poster_path: String
)