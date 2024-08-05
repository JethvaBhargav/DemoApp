package com.example.core.data.source.remote

import android.content.Context
import com.example.core.data.source.local.entity.ItemEntity
import com.example.core.data.source.local.entity.ItemImageEntity
import java.util.ArrayList

class ItemListDataSource {

    companion object itemImage {
        fun addItemImageList(context: Context): ArrayList<ItemImageEntity> {
            val size = 4
            val itemImgList = ArrayList<ItemImageEntity>()

            for (item in 1..size) {
                val item = ItemImageEntity(
                    0, context.getString(com.example.core.R.string._swip_image_url), true
                )
                itemImgList.add(item)
            }
            return itemImgList
        }

        fun addItemList(context: Context): ArrayList<ItemEntity> {
            val size = 26
            val itemList = ArrayList<ItemEntity>()

            for (item in 1..size) {
                if (item % 2 == 0) {
                    val items = ItemEntity(
                        0,
                        context.getString(com.example.core.R.string.item_title_even),
                        context.getString(com.example.core.R.string.item_subTitle_even),
                        context.getString(com.example.core.R.string._swip_image_url)
                    )
                    itemList.add(items)
                } else {
                    val items = ItemEntity(
                        0,
                        context.getString(com.example.core.R.string.item_title_odd),
                        context.getString(com.example.core.R.string.item_subTitle_odd),
                        context.getString(com.example.core.R.string._swip_image_url)
                    )
                    itemList.add(items)
                }
            }
            return itemList
        }
    }
}