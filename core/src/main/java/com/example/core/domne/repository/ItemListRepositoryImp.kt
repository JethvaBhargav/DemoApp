package com.example.core.domne.repository

import com.example.core.data.source.dao.ItemDao
import com.example.core.data.source.local.entity.ItemEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.ArrayList

class ItemListRepositoryImp(
    val dispatcher: CoroutineDispatcher,
    val itemdao: ItemDao,
) : ItemListDataRepository {

    override suspend fun fetchAllItemList(): List<ItemEntity> = withContext(dispatcher) {
        return@withContext itemdao.loadAllItem()
    }

    override suspend fun insertAllItem(item: ArrayList<ItemEntity>) = withContext(dispatcher) {
        itemdao.insert(item)
    }

}