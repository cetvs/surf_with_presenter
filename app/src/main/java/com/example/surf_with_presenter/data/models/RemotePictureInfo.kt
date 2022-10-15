package com.example.surf_with_presenter.data.models

import android.os.Parcelable
import com.example.surf_with_presenter.domain.models.DomainPictureInfo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RemotePictureInfo(
    val id: Int,
    val title: String,
    val content: String,
    val photoUrl: String,
    val publicationDate: Long,
) : Parcelable

fun RemotePictureInfo.toDomainPictureInfo(): DomainPictureInfo =
    DomainPictureInfo(
        id = this.id,
        title = this.title,
        content = this.content,
        photoUrl = this.photoUrl,
        publicationDate = this.publicationDate,
        favoriteDate = null
    )