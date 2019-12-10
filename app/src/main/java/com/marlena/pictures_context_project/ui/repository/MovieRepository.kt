package com.marlena.pictures_context_project.ui.repository

import com.marlena.pictures_context_project.ui.model.TheMovie
import com.marlena.pictures_context_project.ui.service.themovidbapi.MovieClient

class MovieRepository {

    fun getMovieList(): List<TheMovie>? {
        val response = MovieClient.instance.callGetMovies()
        return response?.results
    }
}