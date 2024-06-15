package com.crylent.vkbot.data

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

data class ApiCallback(
    val type: Type,
    @JsonProperty("object") val data: CallbackData?,
    val group_id: Int,
    val secret: String?
) {
    enum class Type {
        @JsonAlias("confirmation") CONFIRMATION,
        @JsonAlias("message_new") MESSAGE_NEW
    }
}