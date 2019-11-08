package com.marlena.pictures_context_project.ui.scenes.gallery_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.Picture
import com.marlena.pictures_context_project.ui.adapter.PictureRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_gallery_2.*

class Gallery2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(

            Picture(
                id_url = 1,
                name = "Meu filhote"
            ),
            Picture(
                 id_url = 2,
                name = "Gatinho Marrom"
            ),
            Picture(
                 id_url = 3,
                name = "Gatinho Nenem"
            ),
            Picture(
                 id_url = 4,
                name = "Gatinho no Jardim"
            ),
            Picture(
                 id_url = 5,
                name = "Gatinhos Coloridos"
            ),
            Picture(
                 id_url = 6,
                name = "Gatinho Fofo"
            ),
            Picture(
                 id_url = 7,
                name = "Golden Retriever"
            ),
            Picture(
                 id_url = 8,
                name = "Gatinho no pote"
            ),
            Picture(
                 id_url = 9,
                name = "The bigger"
            ),
            Picture(
                 id_url = 10,
                name = "Gatinho no vermelho"
            ),
            Picture(
                 id_url = 11,
                name = "Quero abraço"
            )
        )

        val adapter = PictureRecyclerAdapter(list)
//
        recyclerPictureRV?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerPictureRV?.adapter = adapter

    }
}