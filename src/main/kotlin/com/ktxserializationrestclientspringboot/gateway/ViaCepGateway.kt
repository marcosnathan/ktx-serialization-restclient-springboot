package com.ktxserializationrestclientspringboot.gateway

import com.ktxserializationrestclientspringboot.beans.KtxConfig
import com.ktxserializationrestclientspringboot.json.ZipCode
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient


@Component
class ViaCepGateway(
    private val ktxConfig: KtxConfig
) : ZipCodeGateway {

    private val restClient: RestClient = RestClient.builder()
        .messageConverters {
            it.add(0, ktxConfig.ktxMessageConverter())
            it.add(1, ktxConfig.ktxMessageConverterWithMediaType())
        }
        .baseUrl("https://viacep.com.br/ws/")
        .build()


    override fun getInfoCep(cep: String): ZipCode? {
        return restClient.get()
            .uri("/{cep}/json", cep)
            .retrieve()
            .onStatus({ it.is4xxClientError || it.is5xxServerError }, {_, response ->
                throw RuntimeException("Fail to find $cep informations. status code: ${response.statusCode}")
            })
            .body(ZipCode::class.java)
    }
}