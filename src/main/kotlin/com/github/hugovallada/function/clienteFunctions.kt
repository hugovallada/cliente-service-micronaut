package com.github.hugovallada.function

import com.github.hugovallada.model.Cliente

fun Cliente.copy(name: String = this.name, documento: String = this.documento, endereco: String = this.endereco) =
    Cliente(id = this.id, name, documento, endereco, this.active, this.creationTime)