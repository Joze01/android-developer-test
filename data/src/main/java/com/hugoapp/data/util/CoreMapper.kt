package com.hugoapp.data.util

interface CoreMapper<T : Any> {
    fun mapToCoreModel(): T
}