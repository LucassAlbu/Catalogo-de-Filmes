package com.lucassalbu.catalogodefilmeshilt.di

import com.lucassalbu.catalogodefilmeshilt.repositories.Repository
import com.lucassalbu.catalogodefilmeshilt.repositories.RepositoryCDF
import com.lucassalbu.catalogodefilmeshilt.serviceApi.GenreInterface
import com.lucassalbu.catalogodefilmeshilt.serviceApi.PopularMovieInterface
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
        popularMovieInterface: PopularMovieInterface,
        genreInterface: GenreInterface
        ): Repository {
        return RepositoryCDF(popularMovieInterface,genreInterface)
    }

}