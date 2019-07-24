package com.klevy.map

import javafx.application.Application
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MapApplication

private val log = LoggerFactory.getLogger(Application::class.java)

fun main(args: Array<String>) {
	runApplication<MapApplication>(*args)
}
