package com.jkyamaguchi.network.mapper

import retrofit2.Response

fun <T> Response<T>.toModel(): T {
    return if (this.isSuccessful) {
        this.body() ?: error("The response is null")
    } else {
        error("The response was not successful: ${this.errorBody()}")
    }
}