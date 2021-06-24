package com.sc.imagesearch.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.sc.imagesearch.databinding.ImageItemBinding
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.extensions.load

class ImageViewHolder(private val binding: ImageItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Image) {
        with(binding) {
            image.load(item.imageUrl)
        }
    }
}