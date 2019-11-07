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
                image_drawable = R.drawable.a_pearl,
                id = 1,
                name = "Meu filhote"
            ),
            Picture(
                image_drawable = R.drawable.a_gatinho_marrom,
                id = 2,
                name = "Gatinho Marrom"
            ),
            Picture(
                image_drawable = R.drawable.a_gatinho_nenem,
                id = 3,
                name = "Gatinho Nenem"
            ),
            Picture(
                image_drawable = R.drawable.a_gatinho_no_jardim,
                id = 4,
                name = "Gatinho no Jardim"
            ),
            Picture(
                image_drawable = R.drawable.a_collors,
                id = 5,
                name = "Gatinhos Coloridos"
            ),
            Picture(
                image_drawable = R.drawable.a_diamond_kitty,
                id = 6,
                name = "Gatinho Fofo"
            ),
            Picture(
                image_drawable = R.drawable.a_golden_retriever,
                id = 7,
                name = "Golden Retriever"
            ),
            Picture(
                image_drawable = R.drawable.a_kitty_cat,
                id = 8,
                name = "Gatinho no pote"
            ),
            Picture(
                image_drawable = R.drawable.a_maxresdefault,
                id = 9,
                name = "The bigger"
            ),
            Picture(
                image_drawable = R.drawable.a_red_kitty,
                id = 10,
                name = "Gatinho no vermelho"
            ),
            Picture(
                image_drawable = R.drawable.a_sad_want_hug,
                id = 11,
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