package com.sc.imagesearch.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.observable
import com.sc.imagesearch.data.paging.ImagePagingSource
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.domain.repository.ImageRepository
import io.reactivex.Observable

class GetImagePagingSourceUseCaseImpl(
    private val imageRepository: ImageRepository
) : GetImagePagingSourceUseCase {

    override fun invoke(query: String): Observable<PagingData<Image>> {
        return Pager(
            PagingConfig(pageSize = 1)
        ) {
            ImagePagingSource(imageRepository, query)
        }.observable
    }
}