package com.example.domain.model


data class Item(
    var title: String? = null,
    var image: String? = null
): Model()

data class CategoryItemList(
    var sectionType: String? = null,
    var items: List<Item>? = null
) : Model()