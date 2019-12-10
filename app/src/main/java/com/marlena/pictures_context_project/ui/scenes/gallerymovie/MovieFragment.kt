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
import kotlinx.android.synthetic.main.fragment_gallery_landscape.*
import com.marlena.pictures_context_project.ui.model.TheMovie
import com.marlena.pictures_context_project.ui.scenes.picture.PictureActivity
import com.marlena.pictures_context_project.ui.scenes.adapters.movieadapter.MovieAdapter

class MovieFragment : Fragment(), Movie.View, MovieAdapter.Listener {

    private val movieList = mutableListOf<TheMovie>()
    private lateinit var presenter: MoviePresenter
    private var adapter: MovieAdapter? = null

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
            MovieAdapter(
                movieList,
                this
            )
    }

    private fun setupViews() {
        recyclerViewRV?.adapter = adapter
    }

    override fun makeRequests() {
        presenter.getMoviesList()
    }

    override fun setList(list: List<TheMovie>) {
        movieList.clear()
        movieList.addAll(list)

        adapter?.notifyDataSetChanged()
    }

    override fun displayFailure(error: Int) {
        Toast.makeText(context, "Erro na solicitação", Toast.LENGTH_LONG).show()
    }

    override fun openPictureFragment(name: String, release_date: String, url: String, overview: String, itemView: View) {

        val options = ActivityOptions.makeSceneTransitionAnimation(
            activity,
            Pair(itemView, PictureActivity.TRANSITION_IMAGE)
        )

        val intent = Intent(context, PictureActivity::class.java).apply {
            putExtra("imageName", name)
            putExtra("imageRelease_date", release_date)
            putExtra("imageUrl", url)
            putExtra("imageOverview", overview)
        }
        activity?.startActivity(intent, options.toBundle())
    }
}