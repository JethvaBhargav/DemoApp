package com.example.data.repositry

import com.example.data.model.CategoryItemEntityMapper
import com.example.data.remote.api.RetrofitService
import com.example.domain.model.CategoryItemList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CategoryItemRepositoryImpl (
    private val api: RetrofitService,
    private val mapper: CategoryItemEntityMapper,
    private val dispatcher: CoroutineDispatcher
) : CategoryItemRepository {

    override suspend fun getCategoryItem(): List<CategoryItemList> = withContext(dispatcher){
        return@withContext api.getCategory().map {
            mapper.mapToDomain(it)
        }
    }
}