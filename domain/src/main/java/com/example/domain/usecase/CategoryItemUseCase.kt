package com.example.domain.usecase

import com.example.data.repositry.CategoryItemRepository
import com.example.domain.model.CategoryItemList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CategoryItemUseCase(
    private val api: CategoryItemRepository
) {
    fun getCategoryItemData(): Flow<List<CategoryItemList>> = flow {
        val categoryItems = api.getCategoryItem()
        emit(categoryItems)
    }.flowOn(Dispatchers.IO)
}