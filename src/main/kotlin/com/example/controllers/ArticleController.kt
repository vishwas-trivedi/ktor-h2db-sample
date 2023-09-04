package com.example.controllers

import io.ktor.server.routing.*

/**
 *
 * Article controller
 */
fun Route.articleController(){
    route("/article"){

        /**
         * Get all article list
         */
        get{

        }

        /**
         * Used to get article by ID
         */
        get("{id?}"){

        }
    }
}