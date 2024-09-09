package com.example.zapcomdemo

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.example.data.remote.module.dispatcherModule
import com.example.data.remote.module.mapperModule
import com.example.data.remote.module.networkModule
import com.example.zapcomdemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(appModule, networkModule, mapperModule, dispatcherModule)
        }
        MultiDex.install(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}