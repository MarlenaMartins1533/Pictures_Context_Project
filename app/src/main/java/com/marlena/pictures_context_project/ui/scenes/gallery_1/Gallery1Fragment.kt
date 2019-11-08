package com.marlena.pictures_context_project.ui.scenes.gallery_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.Picture
import com.marlena.pictures_context_project.ui.adapter.PictureRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_gallery_1.*

class Gallery1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            Picture(
                id_url = 1,
                name = "FurtaCor"
            ),
            Picture(
                 id_url = 2,
                name = "Paz Roxa"
            ),
            Picture(
                 id_url = 3,
                name = "Lindo Por do Sol"
            ),
            Picture(
                 id_url = 4,
                name = "Banco e luz"
            ),
            Picture(
                 id_url = 5,
                name = "Cachoeira"
            ),
            Picture(
                 id_url = 6,
                name = "Envolvente e caloroso"
            ),
            Picture(
                 id_url = 7,
                name = "Gelo e seren id_urlade"
            ),
            Picture(
                 id_url = 8,
                name = "Inspirador e verde"
            ),
            Picture(
                 id_url = 9,
                name = "Brilho dourado"
            )
        )

        val adapter = PictureRecyclerAdapter(list)
//
        recyclerPictureRV?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerPictureRV?.adapter = adapter

    }
}