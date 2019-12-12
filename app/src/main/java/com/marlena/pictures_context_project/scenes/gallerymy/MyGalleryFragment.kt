package com.marlena.pictures_context_project.scenes.gallerymy

import android.os.Bundle
import android.util.Pair
import android.view.View
import android.widget.Toast
import android.content.Intent
import android.view.ViewGroup
import android.view.LayoutInflater
import android.app.ActivityOptions
import androidx.fragment.app.Fragment
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.model.entity.MyPictureEntity
import com.marlena.pictures_context_project.model.domain.ThePicture
import kotlinx.android.synthetic.main.fragment_gallery_landscape.*
import com.marlena.pictures_context_project.scenes.picture.PictureActivity
import com.marlena.pictures_context_project.scenes.adapters.pictureadapter.PictureAdapter

class MyGalleryFragment : Fragment(),
    MyGallery.View, PictureAdapter.Listener {

    private lateinit var presenter: MyGallery.Presenter
    private val myPictureList: MutableList<MyPictureEntity>
            by lazy { mutableListOf<MyPictureEntity>() }
    private var adapter: PictureAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = MyGalleryPresenter(this)
        return inflater.inflate(R.layout.fragment_gallery_landscape, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapters()
        setupViews()
        makeRequests()
    }

    private fun setupAdapters() {
        val thePictureList = convertMyPicturesListInToDomain(myPictureList)
        adapter =
            PictureAdapter(
                thePictureList,
                this
            )
    }

    private fun convertMyPicturesListInToDomain(
        myPictureList: MutableList<MyPictureEntity>
    ): List<ThePicture> {

        return myPictureList.map {
            ThePicture(
                name = it.name,
                url = it.url
            )
        }
    }

    private fun setupViews() {
        recyclerViewRV?.adapter = adapter
    }

    private fun makeRequests() {
        presenter.getAllList()
    }

    override fun setAllList(list: List<MyPictureEntity>) {
        myPictureList.clear()
        myPictureList.addAll(list)

        if (myPictureList.isEmpty()) displayFailure(1)
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