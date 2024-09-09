package com.example.zapcomdemo.ui.view

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.CategoryItemList
import com.example.zapcomdemo.R
import com.example.zapcomdemo.ui.adapter.ItemListAdapter
import com.example.zapcomdemo.databinding.ActivityItemListBinding
import com.example.zapcomdemo.utils.ResultState
import com.example.zapcomdemo.utils.Utils.ViewShowHide
import com.example.zapcomdemo.utils.Utils.showMsg
import com.example.zapcomdemo.ui.viewmodel.CategoryItemViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryItemListActivity : AppCompatActivity() {

    lateinit var binding: ActivityItemListBinding
    lateinit var itemListAdapter: ItemListAdapter

    private val viewModel: CategoryItemViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_list)

        intiFlow()
    }

    fun intiFlow() {
        viewModel.getCategoryItemRecord()

        lifecycleScope.launchWhenCreated {
            viewModel._categoryItemFlow.collect { state ->
                when (state) {
                    is ResultState.DataState<*> -> {
                        state.data.run {
                            intiCategoryItemList(state.data as ArrayList<CategoryItemList>)
                        }
                    }

                    is ResultState.ErrorState -> {
                        state.run {
                            exception.message!!.showMsg(this@CategoryItemListActivity)
                        }
                    }

                    is ResultState.LoadingState -> {
                        binding.pbProgress.run {
                            ViewShowHide(state.isProgress)
                        }
                    }
                }
            }
        }
    }

    fun intiCategoryItemList(list: ArrayList<CategoryItemList>) {
        itemListAdapter = ItemListAdapter(calclulateDeviceWidth())
        binding.recycleItemList.apply {
            layoutManager = LinearLayoutManager(this@CategoryItemListActivity)
            adapter = itemListAdapter
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
        }
        itemListAdapter.setItemData(list)
    }

    fun calclulateDeviceWidth(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        return width
    }
}