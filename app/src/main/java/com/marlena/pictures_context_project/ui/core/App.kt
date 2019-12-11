package com.marlena.pictures_context_project.ui.core

import android.app.Application
import com.marlena.pictures_context_project.ui.repository.PictureRepository
import com.marlena.pictures_context_project.ui.service.TheCatClient

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        TheCatClient.initialize()
    }

    companion object {

        val pictureRepository = PictureRepository()
    }
}