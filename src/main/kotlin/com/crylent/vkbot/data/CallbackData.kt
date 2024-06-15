package com.crylent.vkbot.data

import com.fasterxml.jackson.annotation.JsonProperty

data class CallbackData(
    val message: InboxMessage,
    @JsonProperty("client_info") val clientInfo: Map<String, Any>
)