package com.marlena.pictures_context_project.ui.model

import com.google.gson.annotations.SerializedName

data class TheMovie(

    @SerializedName("title")
    val title: String,

    @SerializedName("release_date")
    val release_date: String = "unknown",

    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("overview")
    val overview: String = "unknown"


)