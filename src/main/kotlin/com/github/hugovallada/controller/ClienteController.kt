package com.github.hugovallada.controller

import com.github.hugovallada.dto.ClienteRequest
import com.github.hugovallada.dto.ClienteResponse
import com.github.hugovallada.model.Cliente
import com.github.hugovallada.service.ClienteService
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.validation.Validated
import javax.validation.Valid

@Controller("/clientes", produces = [MediaType.APPLICATION_JSON])
@ExecuteOn(TaskExecutors.IO)
@Validated
class ClienteController(private val service: ClienteService) {

    @Post
    @Status(HttpStatus.CREATED)
    fun create(@Valid cliente: ClienteRequest): ClienteRequest {
        service.create(cliente)
        return cliente
    }

    @Get
    fun findAll(page: Pageable): Page<Cliente> = service.findAll(page)

    @Delete("{id}")
    @Status(HttpStatus.NO_CONTENT)
    fun delete(id: Long) {
        service.delete(id)
    }

    @Get("{id}")
    fun findById(id: Long): Cliente = service.findById(id)

    @Put("{id}")
    @Status(HttpStatus.ACCEPTED)
    fun update(id: Long, @Valid cliente: ClienteRequest) {
        service.update(id, cliente)
    }

    @Get("/names")
    fun findByName(@QueryValue name: String): ClienteResponse {
        return service.findByName(name)
    }

    @Put("/soft/{id}")
    @Status(HttpStatus.NO_CONTENT)
    fun softDelete(id: Long) {
        service.softDelete(id)
    }

}