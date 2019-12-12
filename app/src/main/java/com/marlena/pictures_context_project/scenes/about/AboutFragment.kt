package com.marlena.pictures_context_project.scenes.about

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R

class AboutFragment : Fragment(), About.View {

    private lateinit var presenter: AboutPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = AboutPresenter(this)
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
}