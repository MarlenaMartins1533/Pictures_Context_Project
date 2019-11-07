package com.marlena.pictures_context_project.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.Picture
import com.marlena.pictures_context_project.ui.scenes.PictureFragment
import kotlinx.android.synthetic.main.item_picture.view.*
import kotlinx.android.synthetic.main.picture.view.*
import java.util.zip.Inflater

class PictureRecyclerAdapter(private val pictureList: ArrayList<Picture>) :
    RecyclerView.Adapter<PictureRecyclerAdapter.PictureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false)
        return PictureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pictureList.size
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {

        holder.bindView(position)
    }

    inner class PictureViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(position: Int) {
            itemView.image_titleTXT?.text = pictureList[position].name
            itemView.imageIMG.setImageResource(pictureList[position].image_drawable)
            itemView.itemCV.isClickable = true

            itemView.itemCV.setOnClickListener {
                PictureFragment.newInstance(pictureList[position].image_drawable)
            }
        }

    }
}