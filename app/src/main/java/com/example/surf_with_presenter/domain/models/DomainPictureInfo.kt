package com.example.surf_with_presenter.domain.models

import java.sql.Date

data class DomainPictureInfo(
    val id: Int,
    val title: String,
    val content: String,
    val photoUrl: String,
    val publicationDate: Long,
    val favoriteDate: Date?
)