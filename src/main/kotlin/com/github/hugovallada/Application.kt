package com.github.hugovallada

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("com.github.hugovallada")
            .start()
}

