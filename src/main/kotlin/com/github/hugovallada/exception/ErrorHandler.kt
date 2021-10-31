package com.github.hugovallada.exception

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Status

@Controller
class ErrorHandler {

    @Error(exception = RegistroNaoEncontradoException::class, global = true)
    @Status(HttpStatus.NOT_FOUND)
    fun registroNaoEncontrado(ex: RegistroNaoEncontradoException): Erro {
        return Erro(ex.message ?: "Error de Not Found")
    }

}