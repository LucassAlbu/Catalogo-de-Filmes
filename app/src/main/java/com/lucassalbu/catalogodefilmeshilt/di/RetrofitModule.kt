package com.lucassalbu.catalogodefilmeshilt.di

import com.lucassalbu.catalogodefilmeshilt.serviceApi.GenreInterface
import com.lucassalbu.catalogodefilmeshilt.serviceApi.PopularMovieInterface
import com.lucassalbu.catalogodefilmeshilt.utils.Contants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideHttpCliente(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(): PopularMovieInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideHttpCliente())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PopularMovieInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideGenreClient(): GenreInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideHttpCliente())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GenreInterface::class.java)


    }
}