package com.sc.imagesearch.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingActivity<VB : ViewBinding> : AppCompatActivity() {

    private lateinit var _binding: ViewBinding
    protected val binding: VB
        get() = _binding as VB

    abstract val bindingInflater: (LayoutInflater) -> VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        setContentView(_binding.root)
    }

    private fun initBinding() {
        _binding = bindingInflater.invoke(layoutInflater)
    }
}