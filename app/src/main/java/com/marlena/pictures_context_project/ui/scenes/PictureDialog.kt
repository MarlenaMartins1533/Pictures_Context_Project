package com.marlena.pictures_context_project.ui.scenes

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.marlena.pictures_context_project.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picture.*

class PictureDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.activity_picture, null))

            val url = arguments?.getString(URL_ARGS)

            //builder.setView(R.layout.activity_picture)

            pictureIMG.setImageResource(R.drawable.alerta_790x400)
            if (url.isNullOrEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
            else Picasso.get().load(url).into(pictureIMG)

            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {

        private const val URL_ARGS = "url_args"

        fun newInstance(url: String): DialogFragment {
            val dialog = DialogFragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putString(URL_ARGS, url)
            dialog.arguments = args

            return dialog
        }
    }
}