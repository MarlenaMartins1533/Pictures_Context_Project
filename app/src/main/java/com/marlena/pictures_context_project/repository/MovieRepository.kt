package com.marlena.pictures_context_project.repository

import com.marlena.pictures_context_project.model.response.TheMovie
import com.marlena.pictures_context_project.service.themovidbapi.MovieClient

class MovieRepository {

    fun getMovieList(page: Int): List<TheMovie>? {
        val response = MovieClient.instance.callGetMovies(page)
        return response?.results
    }
}