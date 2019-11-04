package com.marlena.pictures_context_project.ui.scenes.gallery_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.marlena.pictures_context_project.R

class Gallery2Fragment : Fragment() {

    private lateinit var gallery2ViewModel: Gallery2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gallery2ViewModel =
            ViewModelProviders.of(this).get(Gallery2ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery_2, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery_2)
        gallery2ViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}