package com.example.neosoftdemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.data.source.local.entity.ItemEntity
import com.example.neosoftdemo.R
import com.example.neosoftdemo.databinding.ItemListRowBinding
import android.widget.Filter
import com.example.neosoftdemo.utils.utils

class ItemListAdapter : RecyclerView.Adapter<ItemListAdapter.ViewHolder>(), Filterable {

    var itemList = ArrayList<ItemEntity>()
    var filterList = itemList

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
        return filterList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val filterResults = FilterResults()
                val filteredItems = if (constraint.isEmpty()) {
                    itemList
                } else {
                    val filterPattern = constraint.toString().lowercase().trim()
                    itemList.filter {
                        it.title.lowercase().contains(filterPattern)
                    }
                }
                filterResults.values = filteredItems
                filterResults.count = filteredItems.size
                return filterResults
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults) {
                filterList = results.values as ArrayList<ItemEntity>
                notifyDataSetChanged()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItemData(itemList: ArrayList<ItemEntity>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun onBind(holder: ViewHolder) {
        with(receiver = holder) {
            with(itemList[position]) {
                binding.textItemTitle.text = this.title
                binding.textItemSubTitle.text = this.subTitle
                utils.loadImage(binding.imgItem, this.imageURL)
            }
        }
    }

    inner class ViewHolder(val binding: ItemListRowBinding) : RecyclerView.ViewHolder(binding.root)

}