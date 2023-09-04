package com.example.config

import com.example.controllers.articleController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        articleController()
    }
}
