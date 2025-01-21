package com.jkyamaguchi.network.mapper

fun <T> Result<T>.toModel(): T {
    return if (this.isSuccess) {
        this.getOrThrow()
    } else {
        error("The result was not successful: ${this.exceptionOrNull()?.message}")
    }
}