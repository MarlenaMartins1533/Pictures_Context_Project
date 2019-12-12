package com.marlena.pictures_context_project.scenes.picture

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

        presenter = PicturePresenter()

        val url = intent.getStringExtra("imageUrl") ?: ""
        val name = intent.getStringExtra("imageName") ?: ""
        val overview = intent.getStringExtra("imageOverview") ?: ""
        setTransitionName(pictureIMG, TRANSITION_IMAGE)

        if (url.isEmpty()) {
            pictureIMG.setImageResource(R.drawable.alerta_790x400)
        } else {
            setPicture(url)
            setView(name, url, overview)
            initListener(url)
        }
    }

    private fun setPicture(url: String) {
        Picasso.get().load(url).into(pictureIMG)
    }

    private fun setView(name: String, url: String, overview: String) {
        nameTXT.text = name
        urlTXT.text = url

        if (overview.isNotEmpty()) {
            overviewTXT.text = overview
            overviewTXT.visibility = View.VISIBLE
            textView_overview.visibility = View.VISIBLE
        }
    }

    private fun initListener(url: String) {
        my_pictureCBX.setOnClickListener {

            if (my_pictureCBX.isChecked) {
                setVisibility(true)
                showMessage(url)
                presenter.insertMyPicture(url)
                showMessage("Imagem ADICIONADA a My Gallery")
            } else {
                setVisibility(false)
                showMessage("Imagem JÁ ADICIONADA vá a My Gallery para desfavoritar")
            }
        }

        saveBTN.setOnClickListener {
            val sensation = getEdt()
            showMessage(sensation)
//                presenter.editMyPicture(url, sensation)
        }
    }

    private fun setVisibility(favorite: Boolean) {
        if (favorite) {
            sensationsEDT.visibility = View.VISIBLE
            textView_sensations.visibility = View.VISIBLE
            saveBTN.visibility = View.VISIBLE

        } else {
            sensationsEDT.visibility = View.GONE
            textView_sensations.visibility = View.GONE
            saveBTN.visibility = View.GONE
        }
    }

    private fun getEdt(): String {
        return sensationsEDT.text.toString()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val TRANSITION_IMAGE = "image"
    }
}
