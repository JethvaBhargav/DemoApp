package com.example.core.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemList")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var title: String,
    val subTitle: String,
    val imageURL: String
)