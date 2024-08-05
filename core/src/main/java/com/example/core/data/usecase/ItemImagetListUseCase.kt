package com.example.core.data.usecase

import com.example.core.data.source.local.entity.ItemImageEntity
import com.example.core.domne.repository.ItemImageRepository
import javax.inject.Inject

class ItemImagetListUseCase @Inject constructor(
    private val repository: ItemImageRepository
) {

    suspend fun insertAllImageList(item: List<ItemImageEntity>) {
        repository.insertAllImageList(item)
    }

    suspend fun fetchAllItemImageList(): List<ItemImageEntity> {
        return repository.fetchAllItemImageList()
    }

}