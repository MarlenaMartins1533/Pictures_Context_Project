package com.marlena.pictures_context_project.scenes.gallerymy

import android.os.Bundle
import android.util.Pair
import android.view.View
import android.widget.Toast
import android.content.Intent
import android.view.ViewGroup
import android.view.LayoutInflater
import android.app.ActivityOptions
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.model.domain.ThePicture
import com.marlena.pictures_context_project.scenes.picture.PictureActivity
import com.marlena.pictures_context_project.scenes.adapters.pictureadapter.PictureAdapter
import kotlinx.android.synthetic.main.fragment_gallery_my.*

class MyGalleryFragment : Fragment(),
    MyGallery.View, PictureAdapter.Listener {

    private lateinit var presenter: MyGallery.Presenter
    private val pictureList = mutableListOf<ThePicture>()
    private var adapter: PictureAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = MyGalleryPresenter(this)
        return inflater.inflate(R.layout.fragment_gallery_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapters()
        setupViews()
        makeRequests()
    }

    private fun setupAdapters() {
        adapter =
            PictureAdapter(
                pictureList,
                this
            )
    }

    private fun setupViews() {

        recyclerViewRV?.adapter = adapter
    }

    private fun makeRequests() {
        presenter.getAllList()
    }

    override fun setAllList(list: List<ThePicture>) {
        pictureList.clear()
        pictureList.addAll(list)

        if (pictureList.isEmpty()) displayFailure(1)
        else adapter?.notifyDataSetChanged()
    }

    override fun removeMyPicture(url: String) {
        val myPicture = presenter.getPicture(url)
        presenter.deleteMyPicture(myPicture)
        presenter.getAllList()
    }

    override fun displayFailure(error: Int) {
        Toast.makeText(context, getString(error), Toast.LENGTH_LONG).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun openPictureFragment(name: String, url: String, overview: String, itemView: View) {

        val options = ActivityOptions.makeSceneTransitionAnimation(
            activity,
            Pair(itemView, PictureActivity.TRANSITION_IMAGE)
        )

        val intent = Intent(context, PictureActivity::class.java).apply {
            putExtra("imageName", name)
            putExtra("imageUrl", url)
            putExtra("imageOverview", overview)
        }
        activity?.startActivity(intent, options.toBundle())
    }

    override fun onDestroy() {
        presenter.kill()
        super.onDestroy()
    }
}