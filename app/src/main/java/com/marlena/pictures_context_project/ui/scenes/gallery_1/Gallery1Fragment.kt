package com.marlena.pictures_context_project.ui.scenes.gallery_1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.Picture
import com.marlena.pictures_context_project.ui.adapter.PictureRecyclerAdapter
import com.marlena.pictures_context_project.ui.scenes.MainActivity
import com.marlena.pictures_context_project.ui.scenes.PictureActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_gallery_1.*
import kotlinx.android.synthetic.main.activity_picture.*

class Gallery1Fragment : Fragment(), PictureRecyclerAdapter.Listener {

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
                id = 1,
                url = "https://image-store.slidesharecdn.com/6d8bec77-43fa-4a9f-b183-e70fa8197397-original.jpeg",
                name = "FurtaCor"
            ),
            Picture(
                 id = 2,
                url ="https://www.photoblog.com/learn/wp-content/uploads/2018/10/mark-harpur-748500-unsplash.jpg",
                name = "Paz Roxa"
            ),
            Picture(
                 id = 3,
                url ="https://img.youtube.com/vi/4Ait-d7106E/hqdefault.jpg",
                name = "Lindo Por do Sol"
            ),
            Picture(
                 id = 4,
                url ="https://i.pinimg.com/236x/a0/16/94/a01694c60570b8dbb10f580f99cef9d8--park-benches-dark-night.jpg",
                name = "Banco e luz"
            ),
            Picture(
                 id = 5,
                url ="https://www.check24.ge/storage/tour/45/gallery/y8jh7-1562770737-EdBjx.jpg",
                name = "Cachoeira"
            ),
            Picture(
                 id = 6,
                url ="https://i.pinimg.com/originals/8b/50/40/8b50400baee33141b7911730b7e7628c.jpg",
                name = "Envolvente e caloroso"
            ),
            Picture(
                 id = 7,
                url ="https://img.freepik.com/foto-gratis/paisaje-hielo_1048-4465.jpg?size=626&ext=jpg",
                name = "Gelo e serenidade"
            ),
            Picture(
                 id = 8,
                url ="https://static.dir.bg/uploads/images/2018/09/25/1549458/768x432.jpg?_=1537867612",
                name = "Inspirador e verde"
            ),
            Picture(
                id = 9,
                url ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVnn4-NxF3PDm1v6-h-eruMXn9ehdack7EJTrWnYgT7WzLZGHP&s",
                name = "Reflexo árvore vermelha"
            ),
            Picture(
                id = 10,
                url ="http://i.imgur.com/Tc1Mb.jpg",
                name = "Reflexo árvore verde"
            )
        )

        val adapter = PictureRecyclerAdapter(list, this)
        recyclerViewRV?.adapter = adapter
    }

    override fun openPictureFragment(url: String) {
        //transformar em activity, abrir com transparencia
        val intent = Intent(context, PictureActivity::class.java)
        intent.putExtra("imageUrl", url)
        startActivity(intent)
    }
}