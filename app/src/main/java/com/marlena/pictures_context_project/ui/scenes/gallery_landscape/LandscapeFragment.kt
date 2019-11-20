package com.marlena.pictures_context_project.ui.scenes.gallery_landscape

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.adapter.PictureRecyclerAdapter
import com.marlena.pictures_context_project.ui.scenes.PictureActivity
import kotlinx.android.synthetic.main.fragment_gallery_landscape.*

class LandscapeFragment : Fragment(), Landscape.View, PictureRecyclerAdapter.Listener{

    private lateinit var presenter: Landscape.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = LandscapePresenter()
        return inflater.inflate(R.layout.fragment_gallery_landscape, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val picturelist = presenter.getAllList()

        val adapter = PictureRecyclerAdapter(picturelist, this)
        recyclerViewRV?.adapter = adapter
    }

    override fun openPictureFragment(url: String) {

        val intent = Intent(context, PictureActivity::class.java)
        intent.putExtra("imageUrl", url)
        startActivity(intent)

//        val dialog = PictureDialog.newInstance(url)
//        dialog.show(childFragmentManager, "Picture Dialog")

    }
}