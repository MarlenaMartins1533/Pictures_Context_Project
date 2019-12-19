package com.marlena.pictures_context_project.ui.scenes.picture

import android.os.Bundle
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

        val url = intent.getStringExtra("imageUrl") ?: ""
        val name = intent.getStringExtra("imageName") ?: ""
        setTransitionName(pictureIMG, TRANSITION_IMAGE)

        if (url.isEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
        else {
            Picasso.get().load(url).into(pictureIMG)
            nameTXT.text = name
            urlTXT.text = url
        }
    }

    companion object {
        const val TRANSITION_IMAGE = "image"
    }
}
