package com.github.hugovallada.controller

import com.github.hugovallada.model.Cliente
import com.github.hugovallada.repository.ClienteRepository
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.http.exceptions.HttpStatusException
import javax.transaction.Transactional

@Controller("/clientes")
open class ClienteController(private val repository: ClienteRepository) {

    @Post
    @Transactional
    open fun create(cliente: Cliente) {
        repository.save(cliente)
    }

    @Get
    fun findAll(): List<Cliente> {
        return repository.findAll();
    }

    @Delete("{id}")
    fun delete(id: Long) {
        repository.findById(id).run {
            if (isPresent) repository.delete(get())
        }
    }

    @Get("{id}")
    fun findById(id: Long): Cliente {
        repository.findById(id).run {
            if (isPresent) return get()
        }

        throw HttpStatusException(HttpStatus.BAD_REQUEST, "Bad Request")
    }

    @Put("{id}")
    @Transactional
    open fun update(@PathVariable id: Long, @Body cliente: Cliente) {
        val savedCliente = repository.findById(id).get()

        savedCliente.documento = cliente.documento
        savedCliente.endereco = cliente.endereco

        repository.update(savedCliente)
    }

}