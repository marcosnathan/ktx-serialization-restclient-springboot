package com.ktxserializationrestclientspringboot.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ZipCode(
    @SerialName("cep")
    val zipCode: String,
    @SerialName("logradouro")
    val street: String,
    @SerialName("uf")
    val stateAcron: String,
    @SerialName("estado")
    val state: String,
    @SerialName("regiao")
    val region: String,
)
