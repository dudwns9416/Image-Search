package com.sc.imagesearch.ui.main

import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.sc.imagesearch.base.view.onThrottleClick
import com.sc.imagesearch.databinding.ImageItemBinding
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.extensions.load

class ImageViewHolder(private val binding: ImageItemBinding, private val action: (Image) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Image) {
        with(binding) {
            image.load(item.thumbnailUrl)

            image.updateLayoutParams {
                height = getImageHeight(item)
            }

            image.onThrottleClick {
                action.invoke(item)
            }
        }
    }

    private fun getImageHeight(item: Image) = getHeightWithWidthRatio(item).toInt()

    private fun getHeightWithWidthRatio(item: Image) =
        item.height * StaggeredGrid.getWidthRatio(3, item.width)
}