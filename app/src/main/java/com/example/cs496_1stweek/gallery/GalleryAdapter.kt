package com.example.cs496_1stweek.gallery

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.cs496_1stweek.R

class GalleryAdapter (
    private var dataset: List<GalleryItem>
    ) : RecyclerView.Adapter<GalleryAdapter.ItemViewHolder>() {

    var onItemClick : ((GalleryItem) -> Unit)? = null

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val pic: ImageView = view.findViewById(R.id.gallery_pic)
        val delete_button : Button = view.findViewById(R.id.delete_button)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryAdapter.ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.gallery_items, parent, false)
        return GalleryAdapter.ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: GalleryAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.pic.setImageURI(item.pic.toUri())
        holder.delete_button.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}