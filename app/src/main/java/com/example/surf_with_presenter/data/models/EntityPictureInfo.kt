package com.example.surf_with_presenter.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.surf_with_presenter.domain.models.DomainPictureInfo
import kotlinx.parcelize.Parcelize
import java.sql.Date

@Parcelize
@Entity(tableName = "pictureInfo")
data class EntityPictureInfo(
    @PrimaryKey
    val id: Int,
    val title: String,
    val content: String,
    val photoUrl: String,
    val publicationDate: Long,
    val favoriteDate: Date?
) : Parcelable

fun EntityPictureInfo.toEntityPictureInfo(): DomainPictureInfo =
    DomainPictureInfo(
        id = this.id,
        title = this.title,
        content = this.content,
        photoUrl = this.photoUrl,
        publicationDate = this.publicationDate,
        favoriteDate = null,
    )