package com.lucassalbu.catalogodefilmeshilt.di

import com.lucassalbu.catalogodefilmeshilt.repositories.Repository
import com.lucassalbu.catalogodefilmeshilt.repositories.RepositoryCDF
import com.lucassalbu.catalogodefilmeshilt.serviceApi.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiInterface: ApiInterface,
        ): Repository {
        return RepositoryCDF(apiInterface)
    }

}