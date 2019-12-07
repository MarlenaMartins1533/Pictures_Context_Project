package com.marlena.pictures_context_project.ui.repository

import com.marlena.pictures_context_project.ui.model.Movie
import com.marlena.pictures_context_project.ui.data.Constants
import com.marlena.pictures_context_project.ui.model.ThePicture
import com.marlena.pictures_context_project.ui.service.themovidb.MovieClient

class MovieRepository {

    fun getMovieList(): List<ThePicture>? {
        val response = MovieClient.instance.callGetMovies()
        val movieList: List<Movie>? = response?.results
        return movieList?.map {
            ThePicture(url = Constants.imageUrlMovie + it.poster_path, name = it.title)
        }
    }
}