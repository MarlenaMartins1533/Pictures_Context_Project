package com.marlena.pictures_context_project.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.Picture
import com.marlena.pictures_context_project.ui.scenes.PictureActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_picture.view.*

class PictureRecyclerAdapter(private val pictureList: ArrayList<Picture>, private val listener: Listener) :
    RecyclerView.Adapter<PictureRecyclerAdapter.PictureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false)
        return PictureViewHolder(view)
    }

    override fun getItemCount() = pictureList.size

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {

        holder.bindView(position)
    }

    inner class PictureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(position: Int) {
            itemView.image_titleTXT?.text = pictureList[position].name

            Picasso.get()
                .load(pictureList[position].url)
                .error(R.drawable.alerta_790x400)
                .into(itemView.imageIMG)
            itemView.itemCV.isClickable = true

            itemView.itemCV.setOnClickListener {
                listener.openPictureFragment(pictureList[position].url)

//                val intent = Intent(this, PictureActivity::class.java)
//                startActivity(intent)
//
////                val intent = Intent(PictureActivity, PictureActivity::class.java)
////                intent.putExtra("key", pictureList[position].url)
////                listener.openPictureFragment(intent)
////
            }
        }
    }

    interface Listener {
        fun openPictureFragment(url: String)
    }
}