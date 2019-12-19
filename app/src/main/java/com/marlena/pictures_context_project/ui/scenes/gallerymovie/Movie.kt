package com.marlena.pictures_context_project.ui.scenes.gallerymovie

import com.marlena.pictures_context_project.ui.model.TheMovie

interface Movie {
    interface View{
        fun displayFailure(error: Int)
        fun makeRequests()
        fun setList(list: List<TheMovie>)
    }
    interface Presenter{
        fun getMoviesList()
        fun kill()
    }
}