package com.crylent.vkbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VkbotApplication

fun main(args: Array<String>) {
	runApplication<VkbotApplication>(*args)
}
