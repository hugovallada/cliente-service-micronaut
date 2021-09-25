package com.github.hugovallada.controller

import com.github.hugovallada.model.Cliente
import com.github.hugovallada.repository.ClienteRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/clientes")
class ClienteController(private val repository: ClienteRepository) {

    @Post
    fun create(cliente: Cliente) {
        repository.save(cliente)
    }

    @Get
    fun findAll() : List<Cliente> {
        return repository.findAll();
    }

}