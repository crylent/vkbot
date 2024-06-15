package com.crylent.vkbot.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ConfigurationProperties(prefix = "vk")
@PropertySource(value = ["vk.properties", "file:config/vk.properties"], ignoreResourceNotFound = true)
data class VkConfig(
    @Value("access_key") var accessKey: String,
    @Value("confirmation_key") var confirmationKey: String,
    @Value("secret_key") var secretKey: String,
    @Value("host") var host: String,
    @Value("api_version") var apiVersion: String
)