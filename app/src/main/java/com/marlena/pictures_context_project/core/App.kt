package com.marlena.pictures_context_project.core

import android.app.Application
import com.marlena.pictures_context_project.persistence.MyPicturesDB
import com.marlena.pictures_context_project.repository.CatRepository
import com.marlena.pictures_context_project.repository.MovieRepository
import com.marlena.pictures_context_project.service.themovidbapi.MovieClient
import com.marlena.pictures_context_project.service.thecatapi.TheCatClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        MyPicturesDB.initialize(this)

        TheCatClient.initialize()
        MovieClient.initialize()
    }

    companion object {
        val catRepository = CatRepository()
        val movieRepository = MovieRepository()
    }
}