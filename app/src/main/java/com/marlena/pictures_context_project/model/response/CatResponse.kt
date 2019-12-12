package com.marlena.pictures_context_project.model.response

import com.google.gson.annotations.SerializedName

data class CatResponse(

    @SerializedName("id")
    val id: String,
    val url: String
)