package com.crylent.vkbot.data

data class ErrorData(
    val error_code: Int,
    val error_msg: String,
    val request_params: Map<String, String>
)
