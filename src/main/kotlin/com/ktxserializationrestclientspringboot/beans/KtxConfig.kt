package com.ktxserializationrestclientspringboot.beans

import kotlinx.serialization.json.Json
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.KotlinSerializationStringHttpMessageConverter
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter

@Configuration
class KtxConfig {

    @Bean
    fun ktxMessageConverter() : KotlinSerializationJsonHttpMessageConverter {
        // if you want to ignore unknown keys from json string,
        // otherwise make sure your data class has all json keys.
        val json = Json { ignoreUnknownKeys = true }
        return KotlinSerializationJsonHttpMessageConverter(json)
    }

    @Bean
    fun ktxMessageConverterWithMediaType() : KotlinSerializationStringHttpMessageConverter<Json> {
        // if you want to ignore unknown keys from json string,
        // otherwise make sure your data class has all json keys.
        val json = Json { ignoreUnknownKeys = true }
        return object : KotlinSerializationStringHttpMessageConverter<Json>(json, MediaType.TEXT_HTML, MediaType("text", "html")){}
    }

}