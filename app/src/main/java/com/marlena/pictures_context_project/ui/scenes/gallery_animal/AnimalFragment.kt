package com.marlena.pictures_context_project.ui.scenes.gallery_animal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.Picture
import com.marlena.pictures_context_project.ui.adapter.PictureRecyclerAdapter
import com.marlena.pictures_context_project.ui.scenes.PictureActivity
import com.marlena.pictures_context_project.ui.scenes.gallery_animal.Animal
import kotlinx.android.synthetic.main.fragment_gallery_landscape.*

class AnimalFragment : Fragment(), Animal.View, PictureRecyclerAdapter.Listener {

    private lateinit var presenter: Animal.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = AnimalPresenter()
        return inflater.inflate(R.layout.fragment_gallery_animal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = presenter.getAllList()
        val adapter = PictureRecyclerAdapter(list, this)
        recyclerViewRV?.adapter = adapter
    }

    override fun openPictureFragment(url: String) {
        val intent = Intent(context, PictureActivity::class.java)
        intent.putExtra("imageUrl", url)
        startActivity(intent)
    }
}