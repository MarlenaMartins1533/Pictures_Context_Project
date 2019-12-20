package com.marlena.pictures_context_project.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null,

    @SerializedName("results")
    @Expose
    val results: List<TheMovie>
)