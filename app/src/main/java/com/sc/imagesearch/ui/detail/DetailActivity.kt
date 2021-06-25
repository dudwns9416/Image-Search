package com.sc.imagesearch.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sc.imagesearch.base.Constants.KEY_IMAGE
import com.sc.imagesearch.databinding.ActivityDetailBinding
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.extensions.load

class DetailActivity : AppCompatActivity() {

    private val image: Image by lazy { requireNotNull(intent.getParcelableExtra(KEY_IMAGE)) }
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fullImage.load(image.imageUrl)
    }
}