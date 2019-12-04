package com.marlena.pictures_context_project.ui.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    //nome
    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null,
    //url
    @SerializedName("results")
    @Expose
    val results: List<Movie>
)