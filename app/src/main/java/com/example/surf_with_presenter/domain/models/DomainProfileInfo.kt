package com.example.surf_with_presenter.domain.models

data class DomainProfileInfo(
    val token: String,
    val id: String,
    val phone: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val city: String,
    val about: String
)