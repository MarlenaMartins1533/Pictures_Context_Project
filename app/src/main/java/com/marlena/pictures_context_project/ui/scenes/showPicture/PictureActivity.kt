package com.marlena.pictures_context_project.ui.scenes.showPicture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marlena.pictures_context_project.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picture.*


class PictureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val url = intent.getStringExtra("imageUrl") ?: ""
        val name = intent.getStringExtra("imageName") ?: ""

        if (url.isEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
        else {
            Picasso.get().load(url).into(pictureIMG)
            nameTXT.text = name
            urlTXT.text = url
        }

    }
}
