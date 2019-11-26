package com.marlena.pictures_context_project.ui.model

import com.google.gson.annotations.SerializedName

data class PictureResponse (
    @SerializedName("original_filename")
    val originalFilename: String,
    val url: String
)



//import com.google.gson.annotations.SerializedName

//data class PictureResponse (
//
//    @SerializedName("breed_ids")
//    val breed_ids: Any,
//    @SerializedName("height")
//    val height: Int,
//    @SerializedName("id")
//    val id: String,
//    @SerializedName("url")
//    val url: String, //url
//    @SerializedName("original_filename")
//    val original_filename: String,
//    @SerializedName("width")
//    val width: Int
//)


//val pictureResponse = PictureResponse("bla.com", "blastatus")
//val picture = ThePicture(url = pictureResponse.message, name = pictureResponse.status, posterPath = pictureResponse.message + pictureResponse.status)