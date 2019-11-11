package com.marlena.pictures_context_project.ui.scenes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.picture.*

class PictureFragment(private val url: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.picture,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (url.isEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
        else Picasso.get().load(url).into(pictureIMG)
    }

    companion object {
        fun newInstance(url: String): PictureFragment {
            return PictureFragment(url)
        }
    }
}