package com.sc.imagesearch.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.sc.imagesearch.base.Constants.KEY_IMAGE
import com.sc.imagesearch.base.activity.BaseViewBindingActivity
import com.sc.imagesearch.base.view.onTextChanged
import com.sc.imagesearch.databinding.ActivityMainBinding
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.extensions.makeGone
import com.sc.imagesearch.extensions.makeVisible
import com.sc.imagesearch.ui.detail.DetailActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = { ActivityMainBinding.inflate(it) }
    private val viewModel: MainViewModel by viewModel()
    private val imagePageAdapter by lazy { ImagePageAdapter(::actionOnClickItem) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        observeData()
        fetchValues()
        bindEvents()
    }

    private fun initView() {
        with(binding.imageList) {
            setHasFixedSize(true)
            itemAnimator = null
            adapter = imagePageAdapter
        }
    }

    private fun observeData() {
        viewModel.pages.observe(this@MainActivity, {
            lifecycleScope.launch {
                it.collectLatest {
                    imagePageAdapter.submitData(it)
                }
            }
        })
    }

    private fun fetchValues() {
        with(viewModel) {
            fetchImagesWithPage()
        }
    }

    private fun bindEvents() {
        with(binding) {
            search.onTextChanged {
                emptyData.makeGone()
                imageList.makeVisible()
                viewModel.searchImagesByKeyword(it.text.toString())
            }

            imagePageAdapter.addLoadStateListener { loadState ->
                handleLoadState(loadState)
            }
        }
    }

    private fun handleLoadState(loadState: CombinedLoadStates) {
        if (loadState.refresh is LoadState.Loading) {
            return
        }

        if (!loadState.append.endOfPaginationReached) {
            return
        }

        if (imagePageAdapter.itemCount < 1) {
            with(binding) {
                emptyData.makeVisible()
                imageList.makeGone()
            }
        }
    }

    private fun actionOnClickItem(it: Image) {
        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra(KEY_IMAGE, it)
        })
    }

}