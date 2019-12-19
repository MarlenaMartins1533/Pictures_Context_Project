package com.marlena.pictures_context_project.repository

import com.marlena.pictures_context_project.model.domain.ThePicture
import com.marlena.pictures_context_project.service.thecatapi.TheCatClient

class CatRepository {

    fun getCatList(): List<ThePicture>? {
        val response = TheCatClient.instance.callGetCats(params)
        return response?.map {
            ThePicture(url = it.url, name = it.id)
        }
    }
}