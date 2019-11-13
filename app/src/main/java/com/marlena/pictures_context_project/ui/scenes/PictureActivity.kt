package com.marlena.pictures_context_project.ui.scenes

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




//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.activity_picture,container,false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        if (url.isEmpty()) pictureIMG.setImageResource(R.drawable.alerta_790x400)
//        else Picasso.get().load(url).into(pictureIMG)
//    }
//
//    companion object {
//        fun newInstance(url: String): PictureActivity {
//            return PictureActivity(url)
//        }
//    }
//}