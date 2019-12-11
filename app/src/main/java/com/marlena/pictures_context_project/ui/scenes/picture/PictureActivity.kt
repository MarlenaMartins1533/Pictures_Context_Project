package com.marlena.pictures_context_project.ui.scenes.picture

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.marlena.pictures_context_project.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.setTransitionName
import com.marlena.pictures_context_project.ui.model.ThePicture
import kotlinx.android.synthetic.main.activity_picture.*

class PictureActivity : AppCompatActivity(), Picture.View {

    private lateinit var presenter: PicturePresenter
//    private lateinit var myPicture: ThePicture

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        presenter = PicturePresenter(this)

        val name = intent.getStringExtra("imageName") ?: ""
        val url = intent.getStringExtra("imageUrl") ?: ""
        val overview = intent.getStringExtra("imageOverview") ?: ""
        setTransitionName(pictureIMG, TRANSITION_IMAGE)

        if (url.isEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
        else {
            setPicture(url)
            setView(name, url, overview)
            initListener()
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

    private fun initListener() {
        my_pictureCBX.setOnClickListener {
            val favorite: Boolean

            if (my_pictureCBX.isChecked) {
                favorite = true
                setVisibility(favorite)
                showMessage("Imagem ADICIONADA a My Gallery")

//                //colocar o insere
//
//                myPicture = ThePicture(favorite, name, url, )
//                val desc = presenter.getEDT()
//                presenter.insertMyPicture(name, url, overview, desc)

            } else {
                favorite = false
                setVisibility(favorite)
                showMessage("Imagem RETIRADA de My Gallery")
//
//                //se o editavel não for vazio deletar
//
//                presenter.deleteMyPicture(name, url, overview, desc)
            }
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

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val TRANSITION_IMAGE = "image"
    }
}
