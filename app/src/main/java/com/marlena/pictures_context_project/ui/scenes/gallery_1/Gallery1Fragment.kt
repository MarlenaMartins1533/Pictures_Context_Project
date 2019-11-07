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
                image_drawable = R.drawable.l_furtacor,
                id = 1,
                name = "FurtaCor"
            ),
            Picture(
                image_drawable = R.drawable.l_paz_roxa,
                id = 2,
                name = "Paz Roxa"
            ),
            Picture(
                image_drawable = R.drawable.l_por_do_sol,
                id = 3,
                name = "Lindo Por do Sol"
            ),
            Picture(
                image_drawable = R.drawable.l_alone,
                id = 4,
                name = "Banco e luz"
            ),
            Picture(
                image_drawable = R.drawable.l_dashbashi,
                id = 5,
                name = "Cachoeira"
            ),
            Picture(
                image_drawable = R.drawable.l_emotional_scenery,
                id = 6,
                name = "Envolvente e caloroso"
            ),
            Picture(
                image_drawable = R.drawable.l_ice,
                id = 7,
                name = "Gelo e serenidade"
            ),
            Picture(
                image_drawable = R.drawable.l_river,
                id = 8,
                name = "Inspirador e verde"
            ),
            Picture(
                image_drawable = R.drawable.l_shinning,
                id = 9,
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