package com.example.neosoftdemo

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.example.core.data.di.ServiceLocator
import com.example.core.domne.repository.ItemImageListRepositoryImp
import com.example.core.domne.repository.ItemListRepositoryImp
import com.example.core.data.usecase.GetStudentListUseCase
import com.example.core.data.usecase.ItemImagetListUseCase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    private val itemRepository: ItemListRepositoryImp
        get() = ServiceLocator.provideItemListRepository(this)

    private val itemImageRepository: ItemImageListRepositoryImp
        get() = ServiceLocator.provideItemImageListRepository(this)

    val getItemListUseCase: GetStudentListUseCase
        get() = GetStudentListUseCase(itemRepository)

    val getItemImageListUseCase: ItemImagetListUseCase
        get() = ItemImagetListUseCase(itemImageRepository)

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}