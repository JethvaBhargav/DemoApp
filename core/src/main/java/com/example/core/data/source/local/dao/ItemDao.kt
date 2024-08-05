package com.example.core.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.source.local.entity.ItemEntity
import com.example.core.data.source.local.entity.ItemImageEntity

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itemList: List<ItemEntity>)

    @Query("SELECT * FROM itemList")
    suspend fun loadAllItem(): List<ItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageList(itemList: List<ItemImageEntity>)

    @Query("SELECT * FROM itemImage")
    suspend fun loadAllItemImage(): List<ItemImageEntity>
}