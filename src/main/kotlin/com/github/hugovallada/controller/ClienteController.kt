package com.github.hugovallada.controller

import com.github.hugovallada.model.Cliente
import com.github.hugovallada.service.ClienteService
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/clientes")
class ClienteController(private val service: ClienteService) {

    @Post
    fun create(cliente: Cliente): HttpResponse<Any> = HttpResponse.created(service.create(cliente))

    @Get
    fun findAll(page: Pageable): HttpResponse<Page<Cliente>> = HttpResponse.ok(service.findAll(page))

    @Delete("{id}")
    fun delete(id: Long): HttpResponse<Any> {
        service.delete(id)
        return HttpResponse.noContent()
    }

    @Get("{id}")
    fun findById(id: Long): HttpResponse<Cliente> = HttpResponse.ok(service.findById(id))

    @Put("{id}")
    fun update(id: Long, cliente: Cliente) : HttpResponse<Any> {
        service.update(id, cliente)
        return HttpResponse.accepted()
    }

    @Get("/names")
    fun findByName(@QueryValue name: String) : HttpResponse<Cliente> {
        return HttpResponse.ok(service.findByName(name))
    }

}