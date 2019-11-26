package com.marlena.pictures_context_project.ui.scenes.galeryanimal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.scenes.pictureadapter.PictureAdapter
import com.marlena.pictures_context_project.ui.model.ThePicture
import com.marlena.pictures_context_project.ui.scenes.showPicture.PictureActivity
import kotlinx.android.synthetic.main.fragment_gallery_landscape.*

class AnimalFragment : Fragment(), Animal.View, PictureAdapter.Listener {

    private lateinit var pictureList: List<ThePicture>
    private lateinit var presenter: Animal.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = AnimalPresenter(this)
        return inflater.inflate(R.layout.fragment_gallery_animal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pictureList = arrayListOf(ThePicture(url = "", name = ""))

        presenter.getCatsList()
        if (pictureList.isNullOrEmpty()) displayFailure(1)
        else {
            val adapter = PictureAdapter(pictureList, this)
            recyclerViewRV?.adapter = adapter
        }
    }

    override fun setAllList(list: List<ThePicture>) {
        pictureList = list
    }

    override fun displayFailure(error: Int) {
        Toast.makeText(context, getString(error), Toast.LENGTH_LONG).show()
    }

    override fun openPictureFragment(url: String) {

        val intent = Intent(context, PictureActivity::class.java)
        intent.putExtra("imageUrl", url)
        startActivity(intent)
    }
}