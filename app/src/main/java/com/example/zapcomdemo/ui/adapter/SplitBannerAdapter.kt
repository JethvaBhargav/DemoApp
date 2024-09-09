package com.example.zapcomdemo.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Item
import com.example.zapcomdemo.R
import com.example.zapcomdemo.databinding.SplitBannerBinding
import com.example.zapcomdemo.utils.Utils
import com.example.zapcomdemo.utils.Utils.BANNER_IMAGE_HEIGHT


class SplitBannerAdapter(var width: Int) : RecyclerView.Adapter<SplitBannerAdapter.ViewHolder>() {

    var itemList = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: SplitBannerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.split_banner, parent, false
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
                binding.splitBannerTitle.text = itemList.get(position).title
                Utils.loadImage(
                    holder.binding.splitBannerImg, this.image!!, width / 2, BANNER_IMAGE_HEIGHT
                )
            }
        }
    }

    inner class ViewHolder(val binding: SplitBannerBinding) : RecyclerView.ViewHolder(binding.root)

}