package com.example.zapcomdemo.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Item
import com.example.domain.model.CategoryItemList
import com.example.zapcomdemo.R
import com.example.zapcomdemo.databinding.ItemListRowBinding

class ItemListAdapter(private var width: Int) : RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    var itemList = ArrayList<CategoryItemList>()

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val binding: ItemListRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list_row, parent, false
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
    fun setItemData(itemList: ArrayList<CategoryItemList>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun onBind(holder: ViewHolder) {
        with(receiver = holder) {
            with(itemList[position]) {
                binding.textItemTitle.text = this.sectionType

                when (this.sectionType) {
                    "splitBanner" -> {
                        val splitBannerAdapter = SplitBannerAdapter(width)
                        binding.rvCategoryRowItem.apply {
                            layoutManager =
                                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
                            adapter = splitBannerAdapter
                            setHasFixedSize(true)
                            isNestedScrollingEnabled = false
                        }

                        splitBannerAdapter.setItemData(this.items as List<Item>)
                    }

                    "banner" -> {
                        val bannerAdapter = BannerAdapter(width)
                        binding.rvCategoryRowItem.apply {
                            layoutManager =
                                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
                            adapter = bannerAdapter
                            setHasFixedSize(true)
                            isNestedScrollingEnabled = false
                        }

                        bannerAdapter.setItemData(this.items as List<Item>)
                    }

                    else -> {
                        val itemListAdapter = HorizontalBannerAdapter()
                        binding.rvCategoryRowItem.apply {
                            layoutManager =
                                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
                            adapter = itemListAdapter
                            setHasFixedSize(true)
                            isNestedScrollingEnabled = false
                        }

                        itemListAdapter.setItemData(this.items as List<Item>)
                    }
                }

            }
        }
    }

    inner class ViewHolder(val binding: ItemListRowBinding) : RecyclerView.ViewHolder(binding.root)

}