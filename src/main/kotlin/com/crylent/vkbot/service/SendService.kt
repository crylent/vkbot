package com.crylent.vkbot.service

import com.crylent.vkbot.config.VkConfig
import com.crylent.vkbot.data.ApiResponse
import com.crylent.vkbot.data.OutgoingMessage
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.converter.FormHttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

private const val METHOD_SEND = "/method/messages.send"

@Service
class SendService(
    @Autowired private val config: VkConfig,
    @Autowired private val mapper: MapperService
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val restClient = RestClient.builder().messageConverters {
        it.add(FormHttpMessageConverter().apply {
            supportedMediaTypes = listOf(MediaType.APPLICATION_FORM_URLENCODED)
        })
    }.build()

    fun sendMessage(userId: Int, text: String): Boolean {
        val msgOut = OutgoingMessage(userId, text, config.accessKey, config.apiVersion)
        val map = mapper.convert(msgOut)

        val response = restClient.post()
            .uri(config.host + METHOD_SEND)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(map)
            .retrieve()
            .body<ApiResponse>()

        return if (response == null) {
            logger.error("Response was not delivered")
            false
        } else if (response.isError) {
            logger.error("[Error ${response.error!!.error_code}] ${response.error.error_msg}")
            false
        } else {
            logger.info("Response (message #${response.response}) is delivered")
            true
        }
    }
}