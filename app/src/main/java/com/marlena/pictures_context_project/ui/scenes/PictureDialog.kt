package com.marlena.pictures_context_project.ui.scenes

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import com.marlena.pictures_context_project.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picture.*

class PictureDialog : AppCompatDialogFragment() {

    private lateinit var customView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return customView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        customView = layoutInflater.inflate(R.layout.activity_picture, null)

        return AlertDialog.Builder(context!!)
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString(URL_ARGS)
        pictureIMG.setImageResource(R.drawable.alerta_790x400)

        if (url.isNullOrEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
        else Picasso.get().load(url).into(pictureIMG)
    }
    //        activity?.let {
//            // Use the Builder class for convenient dialog construction
//            val builder = AlertDialog.Builder(it)
//
////            val inflater = requireActivity().layoutInflater
////            builder.setView(inflater.inflate(R.layout.activity_picture, null))
//
//            builder.setView(R.layout.activity_picture)
//            val url = arguments?.getString(URL_ARGS)
//            pictureIMG.setImageResource(R.drawable.alerta_790x400)
//
//            if (url.isNullOrEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
//            else Picasso.get().load(url).into(pictureIMG)
//
//            // Create the AlertDialog object and return it
//            return builder.create()
//        } ?: throw IllegalStateException("Activity cannot be null")
//        }
//
//        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//            super.onViewCreated(view, savedInstanceState)
//

    companion object {

        private const val URL_ARGS = "url_args"

        fun newInstance(url: String): AppCompatDialogFragment {
            val dialog = AppCompatDialogFragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putString(URL_ARGS, url)
            dialog.arguments = args

            return dialog
        }
    }
}