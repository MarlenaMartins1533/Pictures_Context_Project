package com.marlena.pictures_context_project.ui.repository

import com.marlena.pictures_context_project.ui.model.ThePicture
import com.marlena.pictures_context_project.ui.service.thecatapi.TheCatClient

class CatRepository {

    fun getCatList(): List<ThePicture>? {
        val response = TheCatClient.instance.callGetCats()
        return response?.map {
            ThePicture(url = it.url, name = it.id)
        }
    }
}