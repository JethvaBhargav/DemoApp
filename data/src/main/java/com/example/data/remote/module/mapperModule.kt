package com.example.data.remote.module

import com.example.data.model.CategoryItemEntityMapper
import org.koin.dsl.module

val mapperModule = module {
    single { CategoryItemEntityMapper() }
}