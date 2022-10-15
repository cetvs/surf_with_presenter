package com.example.surf_with_presenter.data.models

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.surf_with_presenter.domain.models.DomainProfileInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "profileInfo")
data class RemoteProfileInfo(
    @PrimaryKey
    val token: String,
    @SerializedName("user_info")
    @Embedded
    val remoteUserInfo: RemoteUserInfo,
) : Parcelable

fun RemoteProfileInfo.toDomainProfileInfo(): DomainProfileInfo =
    DomainProfileInfo(
        token = this.token,
        id = remoteUserInfo.id,
        phone = remoteUserInfo.phone,
        email = remoteUserInfo.email,
        firstName = remoteUserInfo.firstName,
        lastName = remoteUserInfo.lastName,
        avatar = remoteUserInfo.avatar,
        city = remoteUserInfo.city,
        about = remoteUserInfo.about
    )