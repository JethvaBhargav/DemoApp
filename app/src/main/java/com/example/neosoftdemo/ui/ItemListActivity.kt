package com.example.neosoftdemo.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.data.source.local.entity.ItemEntity
import com.example.core.data.source.local.entity.ItemImageEntity
import com.example.core.data.source.remote.ItemListDataSource.itemImage.addItemImageList
import com.example.core.data.source.remote.ItemListDataSource.itemImage.addItemList
import com.example.neosoftdemo.MainApplication
import com.example.neosoftdemo.R
import com.example.neosoftdemo.adapter.ItemImageSwaipAdapter
import com.example.neosoftdemo.adapter.ItemListAdapter
import com.example.neosoftdemo.databinding.ActivityItemListBinding
import com.example.neosoftdemo.utils.utils
import com.example.neosoftdemo.utils.utils.getAllItemTitleArray
import com.example.neosoftdemo.viewmodel.ItemDataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemListActivity : AppCompatActivity() {

    lateinit var binding: ActivityItemListBinding
    lateinit var itemListAdapter: ItemListAdapter

    private val viewModel: ItemDataViewModel by viewModels {
        ItemDataViewModel.ItemViewModelFactory(
            ((this.application) as MainApplication).getItemListUseCase,
            ((this.application) as MainApplication).getItemImageListUseCase,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_list)

        insertAllItemData()
        intiObserver()
        initLisner()
    }

    fun initLisner() {
        binding.edtSearchItem.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                itemListAdapter.filter.filter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        binding.fabBottomSheet.setOnClickListener { view ->
            if (itemListAdapter != null && itemListAdapter.itemList != null) {
                val labelLatterCount = getString(R.string.label_start_with_latter)
                val labelItemCount =
                    getString(R.string.label_total_item) + " " + itemListAdapter.filterList.size
                val latterCount = utils.countLatter(
                    getAllItemTitleArray(itemListAdapter.filterList), labelLatterCount
                )
                val bottomSheetDialog = ItemCountBottomSheetDialog(labelItemCount, latterCount)
                bottomSheetDialog.show(supportFragmentManager, bottomSheetDialog.tag)
            }
        }
    }

    fun insertAllItemData() {
        viewModel.insertItemData(addItemList(this))
        viewModel.insertItemImageData(addItemImageList(this))
    }

    fun intiObserver() {
        viewModel.getItemListData.observe(this, Observer {
            intiItemList(it)
        })

        viewModel.getItemImageListData.observe(this, Observer {
            intiItemImageSwaipList(it)
        })
    }

    fun intiItemList(list: ArrayList<ItemEntity>) {
        itemListAdapter = ItemListAdapter()
        binding.recycleItemList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ItemListActivity)
            adapter = itemListAdapter
        }
        itemListAdapter.setItemData(list)
    }

    fun intiItemImageSwaipList(list: ArrayList<ItemImageEntity>) {
        val viewPagerAdapter = ItemImageSwaipAdapter(this, list)
        binding.viewPagerItemSwip.apply {
            setAdapter(viewPagerAdapter)
        }
        binding.tabLayout.apply {
            setupWithViewPager(binding.viewPagerItemSwip)
        }
    }

}