package com.example.surf_with_presenter.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RemoteUserInfo(
    val id: String,
    val phone: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val city: String,
    val about: String
) : Parcelable