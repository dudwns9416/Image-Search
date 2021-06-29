package com.sc.imagesearch.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sc.imagesearch.R
import com.sc.imagesearch.base.Constants.KEY_IMAGE
import com.sc.imagesearch.databinding.ActivityDetailBinding
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.extensions.formatted
import com.sc.imagesearch.extensions.load

class DetailActivity : AppCompatActivity() {

    private val image: Image by lazy { requireNotNull(intent.getParcelableExtra(KEY_IMAGE)) }
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        with(binding) {
            fullImage.load(image.imageUrl)
            datetime.text = getDatetimeContent()
            image.displaySiteName.let {
                if (it.isNotBlank())
                    siteName.text = getSiteNameContent(it)
            }
        }
    }

    private fun getDatetimeContent() =
        "${image.datetime.formatted()} ${getString(R.string.comment_write)}"

    private fun getSiteNameContent(siteName: String) =
        "${getString(R.string.comment_source)} $siteName"

}