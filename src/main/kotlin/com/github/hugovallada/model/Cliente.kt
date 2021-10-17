package com.github.hugovallada.model

import com.github.hugovallada.dto.ClienteRequest
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.Where
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Where("@.active = true") // qnd fizer um find, só buscara as que tem active = true
@Introspected
class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val documento: String,
    val endereco: String,
    val active: Boolean = true, // existe um bug onde iniciar a variável com is , dará um problema de q não tem getter
    @DateCreated
    val creationTime: LocalDateTime? = null
)