package com.github.hugovallada.model

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Cliente(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        var documento: String,
        var endereco: String,
        @CreationTimestamp
        val creationTime: LocalDateTime? = null
)