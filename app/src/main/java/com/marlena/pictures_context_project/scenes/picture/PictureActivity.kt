package com.marlena.pictures_context_project.scenes.picture

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.marlena.pictures_context_project.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.setTransitionName
import kotlinx.android.synthetic.main.activity_picture.*
import com.marlena.pictures_context_project.model.domain.ThePicture

class PictureActivity : AppCompatActivity(), Picture.View {

    private lateinit var presenter: PicturePresenter
    private lateinit var thePicture: ThePicture

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        presenter = PicturePresenter(this)

        val url = intent.getStringExtra("imageUrl") ?: ""
        val name = intent.getStringExtra("imageName") ?: ""
        val overview = intent.getStringExtra("imageOverview") ?: ""
        setTransitionName(pictureIMG, TRANSITION_IMAGE)

        if (url.isEmpty()) {
            pictureIMG.setImageResource(R.drawable.alerta_790x400)
        } else {
            setPicture(url)
            setView(url, name, overview)
            initListener(url, name)
        }
    }

    private fun setPicture(url: String) {
        Picasso.get().load(url).into(pictureIMG)
    }

    private fun setView(url: String, name: String, overview: String) {
        urlTXT.text = url
        nameTXT.text = name

        if (overview.isNotEmpty()) {
            overviewTXT.text = overview
            overviewTXT.visibility = View.VISIBLE
            textView_overview.visibility = View.VISIBLE
        }
        if (presenter.getMyPictureByUrl(url) != null) {
            my_pictureCBX.isChecked = true
            setVisibility(true)
        }
    }

    private fun initListener(url: String, name: String) {
        var favorite: Boolean

        my_pictureCBX.setOnClickListener {
            if (my_pictureCBX.isChecked) {
                favorite = true
                setVisibility(favorite)
            } else {
                favorite = false
                setVisibility(favorite)

            }
        }

        saveBTN.setOnClickListener {
            val sensation = getEdt()

            if (sensation != "") {
                sensationsTXT.text = sensation
                sensationsEDT.hint = ""
                thePicture = ThePicture(url, name, true, sensation)
                presenter.insertMyPicture(thePicture)
            }
            onBackPressed()
        }
    }

    private fun setVisibility(favorite: Boolean) {
        if (favorite) {
            saveBTN.visibility = View.VISIBLE
            sensationsTXT.visibility = View.VISIBLE
            sensationsEDT.visibility = View.VISIBLE
            textView_sensations.visibility = View.VISIBLE

        } else {
            sensationsEDT.visibility = View.GONE
            textView_sensations.visibility = View.GONE
            saveBTN.visibility = View.GONE
        }
    }

    override fun getEdt(): String {
        val sensations = sensationsEDT.text.toString()
        if (sensations == "") showMessage("Texto vazio!")
        return sensations
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    companion object {
        const val TRANSITION_IMAGE = "image"
    }
}
