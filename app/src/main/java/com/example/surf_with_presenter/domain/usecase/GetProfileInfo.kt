package com.example.surf_with_presenter.domain.usecase

import com.example.surf_with_presenter.data.models.RemoteProfileInfo
import com.example.surf_with_presenter.domain.models.ProfileRequestBody
import com.example.surf_with_presenter.domain.repository.MainRepository
import io.reactivex.Single

class GetProfileInfo(
    private val repository: MainRepository
) {
    suspend operator fun invoke(profileRequestBody: ProfileRequestBody): Single<RemoteProfileInfo> =
            val profileInfo = repository.getProfileInfo(profileRequestBody)
}