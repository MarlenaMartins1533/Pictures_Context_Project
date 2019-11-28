package com.marlena.pictures_context_project.ui.scenes.galerylandscape

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.scenes.pictureadapter.PictureAdapter
import com.marlena.pictures_context_project.ui.scenes.showPicture.PictureActivity
import kotlinx.android.synthetic.main.fragment_gallery_landscape.*

class LandscapeFragment : Fragment(), Landscape.View, PictureAdapter.Listener{

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

        val adapter = PictureAdapter(
            picturelist,
            this

        )
        recyclerViewRV?.adapter = adapter
    }

    override fun openPictureFragment(url: String, name: String) {

        val intent = Intent(context, PictureActivity::class.java)
        intent.putExtra("imageUrl", url)
        intent.putExtra("imageName", name)

        startActivity(intent
//            , ActivityOptions
//            .makeSceneTransitionAnimation(childFragmentManager, view, PictureActivity.TRANSITION_IMAGE)
//            .toBundle()
        )

//        val dialog = PictureDialog.newInstance(url)
//        dialog.show(childFragmentManager, "ThePicture Dialog")

    }
}