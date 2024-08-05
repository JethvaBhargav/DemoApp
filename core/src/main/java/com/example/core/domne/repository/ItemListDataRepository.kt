package com.example.core.domne.repository

import com.example.core.data.source.local.entity.ItemEntity
import java.util.ArrayList

interface ItemListDataRepository {
    suspend fun fetchAllItemList(): List<ItemEntity>
    suspend fun insertAllItem(item: ArrayList<ItemEntity>)
}