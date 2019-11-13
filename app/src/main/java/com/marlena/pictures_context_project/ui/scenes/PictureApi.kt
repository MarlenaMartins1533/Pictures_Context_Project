package com.marlena.pictures_context_project.ui.scenes

interface Movie {
    interface View{
        fun displayPicture(pictureList: List<PictureResponse>)
        fun displayPicture(picture: PictureResponse)
        fun displayFailure(error: Int)
    }
    interface Presenter{
        fun handleGetPicture()
        fun handleGetPicture(picture: String)
    }
}