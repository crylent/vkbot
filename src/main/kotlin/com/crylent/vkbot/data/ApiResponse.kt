package com.crylent.vkbot.data

data class ApiResponse(
    val response: Int?,
    val error: ErrorData?
) {
    val isError get() = error != null
}