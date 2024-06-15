package com.crylent.vkbot.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

private const val PLACEHOLDER = "{quote}"

@Service
class MessageTemplateService(
    @Value("\${msg.template_file}") private val messageTemplateRes: Resource,
    @Value("\${msg.template_placeholder}") private val placeholder: String?
) {
    private val templateString = messageTemplateRes.file.readText()

    fun createMessage(str: String): String = templateString.replace(placeholder ?: PLACEHOLDER, str)
}