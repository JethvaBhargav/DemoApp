package com.example.core.domne.repository

import com.example.core.data.source.dao.ItemDao
import com.example.core.data.source.local.entity.ItemImageEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ItemImageListRepositoryImp(
    private val itemdao: ItemDao,
    private val dispatcher: CoroutineDispatcher,
) : ItemImageRepository {


    override suspend fun fetchAllItemImageList(): List<ItemImageEntity> = withContext(dispatcher) {
        return@withContext itemdao.loadAllItemImage()
    }

    override suspend fun insertAllImageList(item: List<ItemImageEntity>) = withContext(dispatcher) {
        itemdao.insertImageList(item)
    }

}