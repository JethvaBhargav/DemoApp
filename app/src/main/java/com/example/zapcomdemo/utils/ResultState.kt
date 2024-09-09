package com.example.zapcomdemo.utils

sealed class ResultState<out T> {
    data class LoadingState(var isProgress: Boolean) : ResultState<Nothing>()
    data class ErrorState(var exception: Throwable) : ResultState<Nothing>()
    data class DataState<T>(var data: T) : ResultState<T>()
}

