package com.example.surf_with_presenter.data.source.remote

import com.example.surf_with_presenter.data.models.RemotePictureInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header

interface SimpleApi {
    @GET("picture")
    fun getPictureInfo(@Header("Authorization") token: String): Single<List<RemotePictureInfo>>

//    @POST("auth/login")
//    suspend fun getProfileInfo(@Body requestBody: ProfileRequestBody): ProfileInfo?
//
//    @POST("auth/logout")
//    suspend fun postAuthLogout(@Header("Authorization") token: String): Response<Unit>
}