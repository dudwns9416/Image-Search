package com.sc.imagesearch.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sc.imagesearch.databinding.ImageItemBinding
import com.sc.imagesearch.domain.model.Image
import java.util.*

class ImageAdapter(private val action: (Image) -> Unit) : RecyclerView.Adapter<ImageViewHolder>() {

    private val items = ArrayList<Image>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            action
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addItems(images: List<Image>) {
        items.clear()
        items.addAll(images)
        notifyDataSetChanged()
    }

}

