package com.example.core.data.di

import android.app.Application
import androidx.room.Room
import com.example.core.data.source.dao.ItemDao
import com.example.core.data.source.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application, AppDatabase::class.java, AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    internal fun providePhotoDao(appDatabase: AppDatabase): ItemDao {
        return appDatabase.itemDao()
    }

}


