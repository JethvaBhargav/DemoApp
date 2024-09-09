package com.example.zapcomdemo.di

import com.example.data.repositry.CategoryItemRepositoryImpl
import com.example.data.repositry.CategoryItemRepository
import com.example.domain.usecase.CategoryItemUseCase
import com.example.zapcomdemo.ui.viewmodel.CategoryItemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
   factory  { CategoryItemUseCase(get()) } // Provide SomeUseCase dependency
   viewModel { CategoryItemViewModel(get()) } // Inject SomeUseCase into PhotosViewModel
   single<CategoryItemRepository> {
      CategoryItemRepositoryImpl(get(),get(),get())
   }
}
