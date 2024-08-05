package com.example.neosoftdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.core.data.source.local.entity.ItemEntity
import com.example.core.data.source.local.entity.ItemImageEntity
import com.example.core.data.usecase.GetStudentListUseCase
import com.example.core.data.usecase.ItemImagetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class ItemDataViewModel @Inject constructor(
    private val getItemListUsecase: GetStudentListUseCase,
    private val getItemImageUseCase: ItemImagetListUseCase
) : ViewModel() {

    val _getItemListData = MutableLiveData<ArrayList<ItemEntity>>()
    val getItemListData: MutableLiveData<ArrayList<ItemEntity>> = _getItemListData

    val _getItemImageListData = MutableLiveData<ArrayList<ItemImageEntity>>()
    val getItemImageListData: MutableLiveData<ArrayList<ItemImageEntity>> = _getItemImageListData

    fun insertItemData(itemListData: ArrayList<ItemEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            getItemListUsecase.insertAllItem(itemListData)

            val itemList = getItemListUsecase.fetchAllItemList()
            _getItemListData.postValue(itemList as ArrayList)
        }
    }

    fun insertItemImageData(itemImageListData: ArrayList<ItemImageEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            getItemImageUseCase.insertAllImageList(itemImageListData)

            val itemImageList = getItemImageUseCase.fetchAllItemImageList()
            _getItemImageListData.postValue(itemImageList as ArrayList)
        }
    }

    class ItemViewModelFactory(
        private val getItemListUsecase: GetStudentListUseCase,
        private val getItemImageUseCase: ItemImagetListUseCase,
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ItemDataViewModel(
                getItemListUsecase, getItemImageUseCase
            ) as T
        }
    }
}
