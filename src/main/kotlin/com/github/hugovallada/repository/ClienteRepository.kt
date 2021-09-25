package com.github.hugovallada.repository

import com.github.hugovallada.model.Cliente
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long>