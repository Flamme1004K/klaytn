package com.test.kas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KasApplication

fun main(args: Array<String>) {
    runApplication<KasApplication>(*args)
}
