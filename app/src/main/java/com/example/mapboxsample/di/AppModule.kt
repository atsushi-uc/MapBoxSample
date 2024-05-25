package com.example.mapboxsample.di

import android.content.Context
import com.example.mapboxsample.data.repository.SharedPreferenceImpl
import com.example.mapboxsample.domain.repository.LocalDateRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferenceRepository(@ApplicationContext context: Context): LocalDateRepository {
        return SharedPreferenceImpl(context)
    }


}
