package com.example.surf_with_presenter.presentation

import com.example.surf_with_presenter.domain.models.DomainPictureInfo

data class ViewPictureInfo(
    val id: String,
    val title: String,
    val content: String,
    val photoUrl: String,
    val publicationDate: Long,
)

fun DomainPictureInfo.toViewPictureInfo() = ViewPictureInfo(
    id = this.id.toString(),
    title = this.title,
    content = this.content,
    photoUrl = this.photoUrl,
    publicationDate = this.publicationDate,
)