package com.marlena.pictures_context_project.ui.scenes.gallerymovie

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import com.marlena.pictures_context_project.ui.core.App

class MoviePresenter(private val view: Movie.View) : Movie.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main
    private var job: Job? = null

    override fun getMoviesList() {
        job = launch {
            val result = withContext(Dispatchers.IO) {
                App.movieRepository.getMovieList()
            }

            if (result.isNullOrEmpty())
                view.displayFailure(1)
            else
                view.setList(result)
        }
    }

    override fun kill() {
        job?.cancel()
    }
}