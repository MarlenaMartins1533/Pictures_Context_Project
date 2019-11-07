package com.marlena.pictures_context_project.ui.scenes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import kotlinx.android.synthetic.main.picture.*

class PictureFragment(private val image_drawable: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.picture,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pictureIMG.setImageResource(image_drawable)
    }

    companion object {
        fun newInstance(image_drawable: Int): PictureFragment {
            return PictureFragment(image_drawable)
        }
    }
}