package com.github.hugovallada.model

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
    var documento: String,
    var endereco: String,
    val active: Boolean = true, // existe um bug onde iniciar a variável com is , dartá um problema de q não tem getter
    @DateCreated
    val creationTime: LocalDateTime? = null
)