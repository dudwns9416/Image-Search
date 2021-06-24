package com.sc.imagesearch.ui.main

import android.os.Bundle
import android.view.animation.AlphaAnimation
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sc.imagesearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private val imageAdapter by lazy { ImageAdapter() }
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

}