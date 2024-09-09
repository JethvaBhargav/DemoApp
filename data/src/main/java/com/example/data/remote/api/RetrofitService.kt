package com.example.data.remote.api

import com.example.data.model.CategoryItemEntity
import retrofit2.http.GET

interface RetrofitService {
    @GET("b/5BEJ")
    suspend fun getCategory(): ArrayList<CategoryItemEntity>
}