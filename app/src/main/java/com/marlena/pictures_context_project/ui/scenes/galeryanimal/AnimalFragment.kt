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

    private val pictureList = mutableListOf<ThePicture>()
    private lateinit var presenter: Animal.Presenter

    private var adapter: PictureAdapter? = null

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

        setupAdapters()
        setupViews()
        makeRequests()
    }

    private fun setupAdapters() {
        adapter = PictureAdapter(pictureList, this)
    }

    private fun setupViews() {
        recyclerViewRV?.adapter = adapter
    }

    private fun makeRequests() {
        presenter.getCatsList()
    }

    override fun setAllList(list: List<ThePicture>) {
        pictureList.clear()
        pictureList.addAll(list)

        if (pictureList.isEmpty()) displayFailure(1)
        else adapter?.notifyDataSetChanged()
    }

    override fun displayFailure(error: Int) {
        Toast.makeText(context, getString(error), Toast.LENGTH_LONG).show()
    }

    override fun openPictureFragment(url: String, name: String) {

        val intent = Intent(context, PictureActivity::class.java)
        intent.putExtra("imageUrl", url)
        intent.putExtra("imageName", name)
        startActivity(intent)
    }
}