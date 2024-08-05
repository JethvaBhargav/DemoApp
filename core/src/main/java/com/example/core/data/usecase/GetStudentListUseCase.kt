package com.example.core.data.usecase

import com.example.core.data.source.local.entity.ItemEntity
import com.example.core.domne.repository.ItemListDataRepository
import java.util.ArrayList
import javax.inject.Inject

class GetStudentListUseCase @Inject constructor(
    private val repository: ItemListDataRepository
) {

    suspend fun insertAllItem(itemList: ArrayList<ItemEntity>) {
        repository.insertAllItem(itemList)
    }

    suspend fun fetchAllItemList(): List<ItemEntity> {
        return repository.fetchAllItemList()
    }

}