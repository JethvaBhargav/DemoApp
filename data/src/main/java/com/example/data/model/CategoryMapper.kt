package com.example.data.model

import com.example.data.base.EntityMapper
import com.example.data.base.ModelEntity
import com.example.domain.model.CategoryItemList

data class Item(
    var title: String? = null, var image: String? = null
)

data class CategoryItemEntity(
    var sectionType: String? = null, var items: List<Item>? = null
) : ModelEntity()


class CategoryItemEntityMapper : EntityMapper<CategoryItemList, CategoryItemEntity> {
    override fun mapToDomain(entity: CategoryItemEntity): CategoryItemList = CategoryItemList(
        sectionType = entity.sectionType,
        items = entity.items as List<com.example.domain.model.Item>
    )

}