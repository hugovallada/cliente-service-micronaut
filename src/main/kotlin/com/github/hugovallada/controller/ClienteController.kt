package com.github.hugovallada.controller

import com.github.hugovallada.model.Cliente
import com.github.hugovallada.repository.ClienteRepository
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.exceptions.HttpStatusException

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

    @Delete("{id}")
    fun delete(id: Long) {
        repository.findById(id).run {
            if(isPresent) repository.delete(get())
        }
    }

    @Get("{id}")
    fun findById(id: Long) : Cliente {
        repository.findById(id).run {
            if(isPresent) return get()
        }

        throw HttpStatusException(HttpStatus.BAD_REQUEST, "Bad Request")
    }

}