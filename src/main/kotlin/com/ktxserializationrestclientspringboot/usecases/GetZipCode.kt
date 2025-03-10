package com.ktxserializationrestclientspringboot.usecases

import com.ktxserializationrestclientspringboot.gateway.ZipCodeGateway
import com.ktxserializationrestclientspringboot.json.ZipCode
import org.springframework.stereotype.Component


@Component
class GetZipCode(
    private val cepGateway: ZipCodeGateway
) {
    fun execute(cep: String): ZipCode {
        val cepInfo = cepGateway.getInfoCep(cep) ?: throw RuntimeException("No cep found")

        return cepInfo
    }

}