package com.marlena.pictures_context_project.ui.scenes.gallerymovie

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
import com.marlena.pictures_context_project.ui.model.ThePicture
import kotlinx.android.synthetic.main.fragment_gallery_landscape.*
import com.marlena.pictures_context_project.ui.scenes.picture.PictureActivity
import com.marlena.pictures_context_project.ui.scenes.adapters.pictureadapter.PictureAdapter

class MovieFragment : Fragment(), Movie.View, PictureAdapter.Listener {

    private val pictureList = mutableListOf<ThePicture>()
    private lateinit var presenter: MoviePresenter
    private var adapter: PictureAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = MoviePresenter(this)
        return inflater.inflate(R.layout.fragment_gallery_movie, container, false)
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

    override fun makeRequests() {
        presenter.getMoviesList()
    }

    override fun setList(list: List<ThePicture>) {
        pictureList.clear()
        pictureList.addAll(list)

        adapter?.notifyDataSetChanged()
    }

    override fun displayFailure(error: Int) {
        Toast.makeText(context, "Erro na solicitação", Toast.LENGTH_LONG).show()
    }

    override fun openPictureFragment(url: String, name: String, itemView: View) {

        val options = ActivityOptions.makeSceneTransitionAnimation(
            activity,
            Pair(itemView, PictureActivity.TRANSITION_IMAGE)
        )

        val intent = Intent(context, PictureActivity::class.java).apply {
            putExtra("imageUrl", url)
            putExtra("imageName", name)
        }
        activity?.startActivity(intent, options.toBundle())
    }
}