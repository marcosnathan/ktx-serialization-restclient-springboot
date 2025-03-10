package com.ktxserializationrestclientspringboot

import com.ktxserializationrestclientspringboot.usecases.GetZipCode
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class KtxSerializationRestclientSpringbootApplication

fun main(args: Array<String>) {
    runApplication<KtxSerializationRestclientSpringbootApplication>(*args)
}

@Component
class MainCommandLineRunner(
    private val getCep: GetZipCode
): CommandLineRunner {

    private companion object {
        val logger: Logger = LoggerFactory.getLogger(MainCommandLineRunner::class.java)
    }

    override fun run(vararg args: String?) {
        val zipCodeInfo = getCep.execute("01001000")
        logger.info(zipCodeInfo.toString())
    }
}
