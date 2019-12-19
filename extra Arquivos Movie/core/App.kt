package com.marlena.pictures_context_project.ui.core

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
       PictureClient.initialize()
    }
}