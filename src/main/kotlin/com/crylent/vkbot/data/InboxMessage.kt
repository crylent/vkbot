package com.crylent.vkbot.data

data class InboxMessage(
    val id: Int,
    val date: Long,
    val from_id: Int,
    val text: String
)
