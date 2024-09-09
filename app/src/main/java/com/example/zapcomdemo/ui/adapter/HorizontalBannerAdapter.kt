package com.example.zapcomdemo.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Item
import com.example.zapcomdemo.R
import com.example.zapcomdemo.databinding.ItemImageSwipRowBinding
import com.example.zapcomdemo.utils.Utils
import com.example.zapcomdemo.utils.Utils.HORIZONTAL_BANNER_IMAGE_WIDTH_HEIGHT


class HorizontalBannerAdapter : RecyclerView.Adapter<HorizontalBannerAdapter.ViewHolder>() {

    var itemList = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemImageSwipRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_image_swip_row, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBind(holder)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItemData(itemList: List<Item>?) {
        itemList?.let { this.itemList.addAll(it) }
        notifyDataSetChanged()
    }

    fun onBind(holder: ViewHolder) {
        with(receiver = holder) {
            with(itemList[position]) {
                binding.txtCategoryTitle.text = this.title
                Utils.loadImage(
                    holder.binding.imgCategoryPhoto,
                    this.image!!,
                    HORIZONTAL_BANNER_IMAGE_WIDTH_HEIGHT,
                    HORIZONTAL_BANNER_IMAGE_WIDTH_HEIGHT
                )
            }
        }
    }

    inner class ViewHolder(val binding: ItemImageSwipRowBinding) :
        RecyclerView.ViewHolder(binding.root)

}