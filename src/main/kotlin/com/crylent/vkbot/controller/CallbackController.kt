package com.crylent.vkbot.controller

import com.crylent.vkbot.config.VkConfig
import com.crylent.vkbot.data.ApiCallback
import com.crylent.vkbot.data.InboxMessage
import com.crylent.vkbot.service.MessageTemplateService
import com.crylent.vkbot.service.SendService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

private const val DEFAULT_RESPONSE = "ok"

@Suppress("unused")
@RestController
class CallbackController(
    @Autowired private val config: VkConfig,
    @Autowired private val sendService: SendService,
    @Autowired private val messageTemplateService: MessageTemplateService
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun onCallback(@RequestBody callback: ApiCallback): String? {
        try {
            if (callback.secret != config.secretKey) {
                logger.warn("Secret key is incorrect (expected:${config.secretKey}; received:${callback.secret})")
                return null
            }
            return when (callback.type) {
                ApiCallback.Type.CONFIRMATION -> config.confirmationKey
                ApiCallback.Type.MESSAGE_NEW -> if (processMessage(callback.data!!.message)) DEFAULT_RESPONSE else null
            }
        }
        catch (exception: java.lang.NullPointerException) {
            logger.warn("Incorrect JSON data")
            return null
        }
    }

    private fun processMessage(msg: InboxMessage): Boolean {
        logger.info("Message #${msg.id} from ${msg.from_id}: ${msg.text}")
        val responseMsg = messageTemplateService.createMessage(msg.text)
        return sendService.sendMessage(msg.from_id, responseMsg)
    }
}