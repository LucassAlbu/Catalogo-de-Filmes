package com.lucassalbu.catalogodefilmeshilt.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.lucassalbu.catalogodefilmeshilt.repositories.Repository
import com.lucassalbu.catalogodefilmeshilt.repositories.RepositoryCDF
import com.lucassalbu.catalogodefilmeshilt.serviceApi.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val USER_PREFERENCES = "user_preferences"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiInterface: ApiInterface,

    ): Repository {
        return RepositoryCDF( apiInterface)
    }
//    @Singleton
//    @Provides
//    fun providePreferencesDataStore(
//        @ApplicationContext appContext: Context
//    ): DataStore<Preferences> {
//        return PreferenceDataStoreFactory.create(
//            corruptionHandler = ReplaceFileCorruptionHandler(
//                produceNewData = { emptyPreferences() }
//            ), produceFile = {
//                appContext.preferencesDataStoreFile(USER_PREFERENCES)
//            }
//        )
//    }
}