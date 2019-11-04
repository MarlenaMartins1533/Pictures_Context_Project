package com.marlena.pictures_context_project.ui.scenes.gallery_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Gallery2ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Gallery_2 Fragment"
    }
    val text: LiveData<String> = _text
}