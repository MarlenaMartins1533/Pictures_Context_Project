package com.marlena.pictures_context_project.ui.repository

import com.marlena.pictures_context_project.ui.model.PictureResponse
import com.marlena.pictures_context_project.ui.model.ThePicture
import com.marlena.pictures_context_project.ui.service.TheCatClient

class PictureRepository {

    fun getCatsList(): List<ThePicture>?{
        val response = TheCatClient.instance.callGetCats()
        return convertResponseInPictureList(response)
    }

    private fun convertResponseInPictureList(response: List<PictureResponse>?): List<ThePicture>? {
        return response?.map {
            ThePicture(url = it.url, name = it.id)
        }
    }
}