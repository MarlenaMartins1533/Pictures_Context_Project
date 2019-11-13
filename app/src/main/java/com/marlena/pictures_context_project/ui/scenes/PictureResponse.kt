package com.marlena.pictures_context_project.ui.scenes

import com.google.gson.annotations.SerializedName
import com.marlena.pictures_context_project.ui.Picture

data class PictureResponse (
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)
//val pictureResponse = PictureResponse("bla.com", "blastatus")
//val picture = Picture(url = pictureResponse.message, name = pictureResponse.status, posterPath = pictureResponse.message + pictureResponse.status)