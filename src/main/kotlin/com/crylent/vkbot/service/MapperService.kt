package com.crylent.vkbot.service

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.TypeFactory
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap

@Service
class MapperService {
    private val mapper = ObjectMapper().apply {
        configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
    }

    private val mapType = TypeFactory.defaultInstance().constructMapType(
        LinkedMultiValueMap::class.java,
        String::class.java,
        String::class.java
    )

    fun convert(msg: Any): LinkedMultiValueMap<String, String> = mapper.convertValue(msg, mapType)
}