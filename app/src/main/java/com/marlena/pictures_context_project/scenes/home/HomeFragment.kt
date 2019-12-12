package com.marlena.pictures_context_project.scenes.home

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R

class HomeFragment : Fragment(), Home.View {

    private lateinit var presenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = HomePresenter(this)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}