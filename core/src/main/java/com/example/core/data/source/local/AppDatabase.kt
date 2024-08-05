package com.example.core.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core.data.source.dao.ItemDao
import com.example.core.data.source.local.entity.ItemEntity
import com.example.core.data.source.local.entity.ItemImageEntity

/**
 * To manage data items that can be accessed, updated
 * & maintain relationships between them
 *
 */
@Database(entities = [ItemEntity::class, ItemImageEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        const val DB_NAME = "NeosoftListDatabase.db"

        fun getDatabase(appContext: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    appContext, AppDatabase::class.java, AppDatabase::class.simpleName!!
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}