package com.crylent.vkbot.data

import kotlin.random.Random

data class OutgoingMessage(
    val user_id: Int,
    val message: String,
    val access_token: String,
    val v: String,
    val random_id: Int = random.nextInt(),
) {
    companion object {
        private val random = Random(System.currentTimeMillis())
    }
}