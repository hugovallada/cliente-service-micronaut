package com.github.hugovallada.service

import com.github.hugovallada.model.Cliente
import com.github.hugovallada.repository.ClienteRepository
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class ClienteService(private val repository: ClienteRepository) {

    @Transactional
    open fun create(cliente: Cliente) {
        repository.save(cliente)
    }

    fun findAll(): List<Cliente> = repository.findAll()

    fun delete(id: Long) {
        repository.findById(id).run {
            if (isPresent) repository.delete(get())
        }
    }

    fun findById(id: Long): Cliente = repository.findById(id).get()

    @Transactional
    open fun update(id: Long, cliente: Cliente) {
        val recoveredCliente = repository.findById(id).get()
        recoveredCliente.endereco = cliente.endereco
        recoveredCliente.documento = cliente.documento
    }


}