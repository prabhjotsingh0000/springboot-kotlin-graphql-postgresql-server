package com.example.spring.postgresql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringPostgresqlGraphqlApplication

fun main(args: Array<String>) {
	runApplication<SpringPostgresqlGraphqlApplication>(*args)
}
