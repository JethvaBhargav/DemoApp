package com.example.core.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemImage")
data class ItemImageEntity(
    @PrimaryKey(autoGenerate = true) val id: Int, val imageURL: String, var isImage: Boolean = false
)