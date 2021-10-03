package com.github.hugovallada.dto

import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime

@Introspected
data class ClienteResponse(
        val name: String,
        val documento: String,
        val endereco: String,
        val creationTime: LocalDateTime
)