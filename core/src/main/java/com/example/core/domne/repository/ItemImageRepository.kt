package com.example.core.domne.repository

import com.example.core.data.source.local.entity.ItemImageEntity

interface ItemImageRepository {
    suspend fun fetchAllItemImageList(): List<ItemImageEntity>
    suspend fun insertAllImageList(item: List<ItemImageEntity>)
}