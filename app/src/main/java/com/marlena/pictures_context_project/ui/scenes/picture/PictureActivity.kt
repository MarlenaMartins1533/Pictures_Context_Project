package com.marlena.pictures_context_project.ui.scenes.picture

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.marlena.pictures_context_project.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.setTransitionName
import kotlinx.android.synthetic.main.activity_picture.*

class PictureActivity : AppCompatActivity(), Picture.View {

    private lateinit var presenter: PicturePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)
        presenter = PicturePresenter(this)

        val name = intent.getStringExtra("imageName") ?: ""
        val releaseDate = intent.getStringExtra("imageReleaseDate") ?: ""
        val url = intent.getStringExtra("imageUrl") ?: ""
        val overview = intent.getStringExtra("imageOverview") ?: ""
        setTransitionName(pictureIMG, TRANSITION_IMAGE)

        if (url.isEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
        else {
            Picasso.get().load(url).into(pictureIMG)
            nameTXT.text = name
            urlTXT.text = url
            if (releaseDate.isNotEmpty()) {
                release_dateTXT.text = releaseDate
                release_dateTXT.visibility = View.VISIBLE
                textView_release_date.visibility = View.VISIBLE
                textView_release_date.visibility
            }
            if (overview.isNotEmpty()) {
                overviewTXT.text = overview
                overviewTXT.visibility = View.VISIBLE
                textView_overview.visibility = View.VISIBLE
                textView_overview.visibility
            }
        }
    }

    companion object {
        const val TRANSITION_IMAGE = "image"
    }
}
