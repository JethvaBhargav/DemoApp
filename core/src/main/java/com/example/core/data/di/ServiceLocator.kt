package com.example.core.data.di

import android.content.Context
import com.example.core.data.source.local.AppDatabase
import com.example.core.domne.repository.ItemImageListRepositoryImp
import com.example.core.domne.repository.ItemListRepositoryImp

import kotlinx.coroutines.Dispatchers

object ServiceLocator {
    private var database: AppDatabase? = null

    @Volatile
    var itemListRepository: ItemListRepositoryImp? = null

    @Volatile
    var itemImageListRepository: ItemImageListRepositoryImp? = null

    fun provideItemListRepository(context: Context): ItemListRepositoryImp {
        synchronized(this) {
            return itemListRepository ?: createItemListRepository(context)
        }
    }

    fun provideItemImageListRepository(context: Context): ItemImageListRepositoryImp {
        synchronized(this) {
            return itemImageListRepository ?: createItemImageRepository(context)
        }
    }

    private fun createItemListRepository(context: Context): ItemListRepositoryImp {
        val database = database ?: createDataBase(context)
        return ItemListRepositoryImp(
            Dispatchers.IO,
            database.itemDao(),

            )
    }

    private fun createItemImageRepository(context: Context): ItemImageListRepositoryImp {
        val database = database ?: createDataBase(context)
        return ItemImageListRepositoryImp(
            database.itemDao(),
            Dispatchers.IO,
        )
    }

    private fun createDataBase(context: Context): AppDatabase {
        val result = AppDatabase.getDatabase(context)
        database = result
        return result
    }
}