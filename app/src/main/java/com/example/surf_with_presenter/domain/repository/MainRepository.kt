package com.example.surf_with_presenter.domain.repository

import com.example.surf_with_presenter.domain.models.DomainPictureInfo
import com.example.surf_with_presenter.domain.models.DomainProfileInfo
import com.example.surf_with_presenter.domain.models.ProfileRequestBody
import io.reactivex.Single

interface MainRepository {
    fun getProfileInfo(profileRequestBody: ProfileRequestBody): Single<DomainProfileInfo>
    fun getPictureInfo(token: String): Single<List<DomainPictureInfo>>
}