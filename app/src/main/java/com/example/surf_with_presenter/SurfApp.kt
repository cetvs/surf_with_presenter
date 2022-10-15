package com.example.surf_with_presenter

import android.app.Application
import com.example.surf_with_presenter.domain.models.ProfileRequestBody
import com.example.surf_with_presenter.di.AppComponent
import com.example.surf_with_presenter.di.AppModule
import com.example.surf_with_presenter.di.DaggerAppComponent

class SurfApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        val profileRequestBody = ProfileRequestBody("+79876543219", "qwerty")
//        val profileInfo = mainViewModel.getProfileInfo(profileRequestBody)
    }
}