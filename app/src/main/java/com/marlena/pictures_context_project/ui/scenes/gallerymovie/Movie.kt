package com.marlena.pictures_context_project.ui.scenes.gallerymovie

import com.marlena.pictures_context_project.ui.model.ThePicture

interface Movie {
    interface View{
        fun displayFailure(error: Int)
        fun makeRequests()
        fun setList(list: List<ThePicture>)
    }
    interface Presenter{
        fun getMoviesList()
        fun kill()
    }
}