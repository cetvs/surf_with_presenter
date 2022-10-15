package com.example.surf_with_presenter.di

import com.example.surf_with_presenter.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}