package com.github.hugovallada.service

import com.github.hugovallada.exception.RegistroNaoEncontradoException
import com.github.hugovallada.model.Cliente
import com.github.hugovallada.repository.ClienteRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class ClienteService(private val repository: ClienteRepository) {

    @Transactional
    open fun create(cliente: Cliente) {
        repository.save(cliente)
    }

    fun findAll(pageable: Pageable): Page<Cliente> = repository.findAll(pageable)

    fun delete(id: Long) {
        repository.findById(id).run {
            if (isPresent) repository.delete(get()) else throw RegistroNaoEncontradoException("Registro Não Encontrado")
        }
    }

    fun findById(id: Long): Cliente {
        repository.findById(id).run {
            if(isPresent) return get()
        }

        throw RegistroNaoEncontradoException("Registro Não encontrado")
    }

    @Transactional
    open fun update(id: Long, cliente: Cliente) {
        val recoveredCliente = findById(id)
        recoveredCliente.endereco = cliente.endereco
        recoveredCliente.documento = cliente.documento
    }

}