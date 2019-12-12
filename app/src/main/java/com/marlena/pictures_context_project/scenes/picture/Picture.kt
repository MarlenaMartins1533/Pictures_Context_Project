package com.marlena.pictures_context_project.scenes.picture

interface Picture {
    interface View {
        fun showMessage(message: String)
    }

    interface Presenter {
        fun insertMyPicture(url: String)
    }
}