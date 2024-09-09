package com.example.data.repositry
import com.example.domain.model.CategoryItemList


interface CategoryItemRepository : Repository {
    suspend fun getCategoryItem(): List<CategoryItemList>
}