package com.example.neosoftdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.core.data.source.local.entity.ItemImageEntity
import com.example.neosoftdemo.R
import com.example.neosoftdemo.utils.utils

class ItemImageSwaipAdapter(
    context: Context, itemImgList: ArrayList<ItemImageEntity>
) : PagerAdapter() {
    private var imageUrls = itemImgList
    private val inflater: LayoutInflater = LayoutInflater.from(context)


    override fun getCount(): Int {
        return imageUrls.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = inflater.inflate(R.layout.item_image_swip_row, container, false)
        val mItemImgSwip = view.findViewById<ImageView>(R.id.img_item_swip)
        utils.loadImage(mItemImgSwip, imageUrls.get(position).imageURL)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
