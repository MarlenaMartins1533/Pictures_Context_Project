package com.marlena.pictures_context_project.ui.scenes.gallery_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.PictureModel
import com.marlena.pictures_context_project.ui.adapter.PictureRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_gallery_1.*
import kotlinx.android.synthetic.main.item_picture.*

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
            PictureModel(
                image_drawable = imageIMG.setImageResource(R.drawable.gatinho_marrom),
                id = 1,
                name = "Gatinho Marrom"
            ),
            PictureModel(
                image_drawable = imageIMG.setImageResource(R.drawable.gatinho_nenem),
                id = 2,
                name = "Gatinho Nenem"
            ),
            PictureModel(
                image_drawable = imageIMG.setImageResource(R.drawable.gatinho_no_jardim),
                id = 3,
                name = "Gatinho No Jardim"
            )
        )

        val adapter = PictureRecyclerAdapter(list)
//
        recyclerPictureRV?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerPictureRV?.adapter = adapter

    }
}