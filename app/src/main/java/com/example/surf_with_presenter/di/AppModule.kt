package com.example.surf_with_presenter.di

import android.app.Application
import androidx.room.Room
import com.example.surf_with_presenter.data.repository.MainRepositoryImpl
import com.example.surf_with_presenter.data.source.local.AppDatabase
import com.example.surf_with_presenter.data.source.remote.Constants
import com.example.surf_with_presenter.data.source.remote.SimpleApi
import com.example.surf_with_presenter.domain.repository.MainRepository
import com.example.surf_with_presenter.domain.usecase.GetPictureInfo
import com.example.surf_with_presenter.domain.usecase.MainUseCases
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {
    @Provides
    @Singleton
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSimpleApi(retrofit: Retrofit): SimpleApi {
        return retrofit.create(SimpleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepositoryDatabase(db: AppDatabase, simpleApi: SimpleApi): MainRepository {
        return MainRepositoryImpl(db.menuDao(), simpleApi)
    }

    @Provides
    @Singleton
    fun provideMenuUseCases(
        mainRepository: MainRepository,
    ): MainUseCases {
        return MainUseCases(
            getPictureInfo = GetPictureInfo(mainRepository)
        )
    }
}