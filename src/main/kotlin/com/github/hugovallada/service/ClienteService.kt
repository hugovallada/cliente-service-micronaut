package com.github.hugovallada.service

import com.github.hugovallada.dto.ClienteRequest
import com.github.hugovallada.dto.ClienteResponse
import com.github.hugovallada.exception.RegistroNaoEncontradoException
import com.github.hugovallada.model.Cliente
import com.github.hugovallada.repository.ClienteRepository
import com.github.hugovallada.translator.ClienteRequestToClienteTranslator
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
class ClienteService(private val repository: ClienteRepository) {

    @Transactional
    fun create(cliente: ClienteRequest) {
        repository.save(ClienteRequestToClienteTranslator.translate(cliente))
    }

    fun findAll(pageable: Pageable): Page<Cliente> = repository.findAll(pageable)

    @Transactional
    fun delete(id: Long) {
        findById(id).run { repository.delete(this) }
    }

    fun findById(id: Long): Cliente {
        repository.findById(id).run {
            if(isPresent) return get()
        }

        throw RegistroNaoEncontradoException("Registro Não encontrado")
    }

    @Transactional
    fun update(id: Long, cliente: ClienteRequest) {
        findById(id).run {
            endereco = cliente.endereco
            documento = cliente.documento
        }
    }

    fun findByName(name: String) : ClienteResponse {
        return repository.find(name) ?: throw RegistroNaoEncontradoException("Registro não encontrado")
    }

}