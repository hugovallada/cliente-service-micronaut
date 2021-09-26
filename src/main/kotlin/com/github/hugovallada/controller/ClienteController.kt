package com.github.hugovallada.controller

import com.github.hugovallada.model.Cliente
import com.github.hugovallada.repository.ClienteRepository
import com.github.hugovallada.service.ClienteService
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.http.exceptions.HttpStatusException
import javax.transaction.Transactional

@Controller("/clientes")
class ClienteController(private val service: ClienteService) {

    @Post
    fun create(cliente: Cliente) = service.create(cliente)

    @Get
    fun findAll(): List<Cliente>  = service.findAll()

    @Delete("{id}")
    fun delete(id: Long) = service.delete(id)

    @Get("{id}")
    fun findById(id: Long): Cliente = service.findById(id)

    @Put("{id}")
    fun update(id: Long, cliente: Cliente) = service.update(id, cliente)

}