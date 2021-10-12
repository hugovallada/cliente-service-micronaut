package com.github.hugovallada.translator

import com.github.hugovallada.dto.ClienteRequest
import com.github.hugovallada.model.Cliente

class ClienteRequestToClienteTranslator {

    companion object {
        fun translate(cliente: ClienteRequest) = Cliente(
            name = cliente.name, documento = cliente.documento, endereco = cliente.endereco
        )
    }

}