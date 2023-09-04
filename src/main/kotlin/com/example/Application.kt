package com.example

import com.example.config.configureRouting
import com.example.config.configureSerialization
import com.example.dao.DatabaseFactory
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    DatabaseFactory.init()
    configureRouting()
}
