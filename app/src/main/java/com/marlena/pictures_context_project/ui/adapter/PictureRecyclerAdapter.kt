package com.marlena.pictures_context_project.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marlena.pictures_context_project.R
import com.marlena.pictures_context_project.ui.PictureModel
import kotlinx.android.synthetic.main.item_picture.view.*

class PictureRecyclerAdapter(private val pictureList: ArrayList<PictureModel>): RecyclerView.Adapter<PictureRecyclerAdapter.PictureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false))
    }
//    imageIMG.setImageResource(R.drawable.)
    override fun getItemCount(): Int = pictureList.size

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {

        with(holder.itemView){
            image_titleTXT?.text = pictureList[position].name
//            imageIMG.setImageResource(R.drawable.)
            image_idTXT?.text = "$position"
        }
    }
    inner class PictureViewHolder(view: View): RecyclerView.ViewHolder(view){}
}