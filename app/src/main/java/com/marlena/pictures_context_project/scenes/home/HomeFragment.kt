package com.marlena.pictures_context_project.scenes.home

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), Home.View {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners(){
        homeBTN.setOnClickListener{
            if (homeIMG.visibility == View.VISIBLE) setView(false)
            else setView(true)
        }
    }

    private fun setView(visibility: Boolean){
        if (visibility){
            View.VISIBLE.let {
                box_catIMG.visibility = it
                box_landscapeIMG.visibility = it
                box_movieIMG.visibility = it
                box_myIMG.visibility = it
                homeIMG.visibility = it
            }

        }else {
            View.GONE.let {
                box_catIMG.visibility = it
                box_landscapeIMG.visibility = it
                box_movieIMG.visibility = it
                box_myIMG.visibility = it
                homeIMG.visibility = it
            }
        }
    }
}