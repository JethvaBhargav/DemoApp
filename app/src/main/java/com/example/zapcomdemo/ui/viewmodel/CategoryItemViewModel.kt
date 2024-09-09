package com.example.zapcomdemo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.CategoryItemUseCase
import com.example.zapcomdemo.utils.ResultState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CategoryItemViewModel(private val getPhotosUseCase: CategoryItemUseCase) : ViewModel() {

    var categoryItemFlow = MutableSharedFlow<ResultState<Any>>()
    val _categoryItemFlow = categoryItemFlow.asSharedFlow()

    fun getCategoryItemRecord() {
        viewModelScope.launch {
            categoryItemFlow.emit(ResultState.LoadingState(true))
            getPhotosUseCase.getCategoryItemData().catch { e ->
                e.printStackTrace()
                categoryItemFlow.emit(ResultState.ErrorState(e))
                categoryItemFlow.emit(ResultState.LoadingState(false))

            }.collect { data ->
                delay(1000)
                categoryItemFlow.emit(ResultState.DataState(data))
                categoryItemFlow.emit(ResultState.LoadingState(false))
            }
        }
    }
}