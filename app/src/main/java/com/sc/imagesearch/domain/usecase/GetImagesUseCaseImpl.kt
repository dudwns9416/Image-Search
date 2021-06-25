package com.sc.imagesearch.domain.usecase

import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.network.PageResponse
import com.sc.imagesearch.domain.repository.ImageRepository
import io.reactivex.Observable

class GetImagesUseCaseImpl(
    private val imageRepository: ImageRepository
) : GetImagesUseCase {

    override fun invoke(query: String): Observable<PageResponse<Image>> {
        return imageRepository.findImages(query)
    }

}