package com.example.surf_with_presenter.domain.usecase

import com.example.surf_with_presenter.domain.models.DomainPictureInfo
import com.example.surf_with_presenter.domain.repository.MainRepository
import io.reactivex.Single

class GetPictureInfo(
    private val repository: MainRepository,
) {
    operator fun invoke(token: String): Single<List<DomainPictureInfo>> =
        repository.getPictureInfo(token)
}