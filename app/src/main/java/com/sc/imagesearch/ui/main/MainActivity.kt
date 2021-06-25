package com.sc.imagesearch.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import com.sc.imagesearch.base.Constants.KEY_IMAGE
import com.sc.imagesearch.databinding.ActivityMainBinding
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.ui.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private val imageAdapter by lazy { ImageAdapter(::actionOnClickItem) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        observeData()
        loadValues()
    }

    private fun initView() {
        with(binding.imageList) {
            setHasFixedSize(true)
            startAnimation(AlphaAnimation(0.0f, 1.0f).apply { duration = 1000 })
            itemAnimator = null
            adapter = imageAdapter
        }
    }

    private fun observeData() {
        viewModel.images.observe(this, {
            imageAdapter.addItems(it)
        })
    }

    private fun loadValues() {
        with(viewModel) {
            loadImages()
        }
    }

    private fun actionOnClickItem(it: Image) {
        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra(KEY_IMAGE, it)
        })
    }

}