package com.marlena.pictures_context_project.scenes.gallerymovie

import com.marlena.pictures_context_project.model.response.TheMovie

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