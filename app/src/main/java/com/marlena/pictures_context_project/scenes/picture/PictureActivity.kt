package com.marlena.pictures_context_project.scenes.picture

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.squareup.picasso.Picasso
import com.marlena.pictures_context_project.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.setTransitionName
import kotlinx.android.synthetic.main.activity_picture.*
import com.marlena.pictures_context_project.model.domain.ThePicture

class PictureActivity : AppCompatActivity(), Picture.View {

    private lateinit var presenter: PicturePresenter
    private lateinit var thePicture: ThePicture
    lateinit var sensations: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        presenter = PicturePresenter(this)

        val url = intent.getStringExtra("imageUrl") ?: ""
        val name = intent.getStringExtra("imageName") ?: ""
        val overview = intent.getStringExtra("imageOverview") ?: ""
        sensations = presenter.getSensations(url)

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
        if (sensations.isNotEmpty()) {
            my_pictureCBX.isChecked = true
            setVisibility(true)
            sensationsTXT.text = sensations
        }
    }

private fun initListener(url: String, name: String) {

    my_pictureCBX.setOnClickListener {
        if (my_pictureCBX.isChecked) {
            setVisibility(true)
        } else {
            showAlertDialog(
                url,
                "Atenção!",
                "Você deseja remover essa imagem de My Gallery?"
            )
        }
    }
    saveBTN.setOnClickListener {
        sensations = getEdt()

        if (sensations != "") {
            sensationsTXT.text = sensations
            sensationsEDT.hint = ""
            thePicture = ThePicture(url, name)
            presenter.insertMyPicture(thePicture, sensations)
            onBackPressed()
        }
    }
}

fun showAlertDialog(url: String, title: String, message: String) {
    AlertDialog.Builder(this).apply {
        setTitle(title)
        setMessage(message)
        setPositiveButton("APAGAR") { _: DialogInterface, _: Int ->
            run {
                presenter.deletePicture(url)
                sensations = ""
                setVisibility(false)
            }
        }
        setNegativeButton("Cancelar") { _: DialogInterface, _: Int ->
            run {
                my_pictureCBX.setChecked(true)
                showMessage("Cancelado")
            }
        }
        show()
    }
}

private fun setVisibility(check: Boolean) {
    if (check)
        View.VISIBLE.let {
            my_pictureCBX.isChecked = check
            textView_sensations.visibility = it
            sensationsTXT.visibility = it
            sensationsEDT.visibility = it
            saveBTN.visibility = it
        }
    else {
        if (sensations == "") {
            textView_sensations.visibility = View.GONE
            sensationsTXT.visibility = View.GONE
        } else {
            textView_sensations.visibility = View.VISIBLE
            sensationsTXT.visibility = View.VISIBLE
        }
        my_pictureCBX.isChecked = check
        sensationsEDT.visibility = View.GONE
        saveBTN.visibility = View.GONE
    }
}

override fun getEdt(): String {
    val sensations = sensationsEDT.text.toString()
    if (sensations.isEmpty()) showMessage("Texto vazio!")
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
