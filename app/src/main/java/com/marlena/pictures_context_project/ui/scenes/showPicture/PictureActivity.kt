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

        if (url.isEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
        else Picasso.get().load(url).into(pictureIMG)
    }
}


//class PictureActivity(context: Context) : App {
//    private val url = intent.getStringExtra("imageUrl") ?: ""
//
//    init {
//        setCancelable(false)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_picture)
//
//        goSetImage()
//
//    }
//
//    fun goSetImage(){
//        if (url.isNullOrEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
////        else Picasso.get().load(url).into(pictureIMG)
//    }
//
//
//}
//
//    AlertDialog.Builder(this).apply {
//        setTitle(title)
//        setMessage(message)
//        show()
//    }







//DiologFragment

//package com.marlena.pictures_context_project.ui
//
//import android.app.Dialog
//import android.os.Bundle
//import androidx.appcompat.app.AlertDialog
//import androidx.fragment.app.DialogFragment
//import com.marlena.pictures_context_project.R
//import kotlinx.android.synthetic.main.activity_picture.*
//
//class PictureDialog : DialogFragment() {
//
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        return activity?.let {
//            // Use the Builder class for convenient dialog construction
//            val builder = AlertDialog.Builder(it)
////            val inflater = requireActivity().layoutInflater
////            builder.setView(inflater.inflate(R.layout.activity_picture, null))
//
//                builder.setView(R.layout.activity_picture)
//                pictureIMG.setImageResource(R.drawable.alerta_790x400)
////                if (url.isEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
////                else Picasso.get().load(url).into(pictureIMG)
//
//            // Create the AlertDialog object and return it
//            builder.create()
//        } ?: throw IllegalStateException("Activity cannot be null")
//    }
//
//}
