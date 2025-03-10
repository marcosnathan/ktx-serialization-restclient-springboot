package com.ktxserializationrestclientspringboot.gateway

import com.ktxserializationrestclientspringboot.json.ZipCode

interface ZipCodeGateway{
    fun getInfoCep(cep: String): ZipCode?
}