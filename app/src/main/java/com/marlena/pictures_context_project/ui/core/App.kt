package com.marlena.pictures_context_project.ui.core

import android.app.Application
import com.marlena.pictures_context_project.ui.repository.CatRepository
import com.marlena.pictures_context_project.ui.repository.MovieRepository
import com.marlena.pictures_context_project.ui.service.themovidbapi.MovieClient
import com.marlena.pictures_context_project.ui.service.thecatapi.TheCatClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        TheCatClient.initialize()
        MovieClient.initialize()
    }

    companion object {
        val catRepository = CatRepository()
        val movieRepository = MovieRepository()
    }
}