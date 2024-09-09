package com.example.data.remote.module

import com.example.data.remote.api.RetrofitService
import com.example.data.util.HttpClient.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder().baseUrl(BASE_URL) // Replace with your API base URL
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    single<RetrofitService> {
        get<Retrofit>().create(RetrofitService::class.java)
    }
}

