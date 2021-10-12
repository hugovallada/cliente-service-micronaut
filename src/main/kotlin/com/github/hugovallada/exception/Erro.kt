package com.github.hugovallada.exception

import java.time.LocalDateTime

data class Erro(
    val msg: String,
    val time: String = LocalDateTime.now().toString()
)
