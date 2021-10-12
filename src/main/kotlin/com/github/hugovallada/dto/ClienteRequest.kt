package com.github.hugovallada.dto

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class ClienteRequest(
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val endereco: String,
    @field:NotBlank
    val documento: String
)
