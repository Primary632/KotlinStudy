package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.plugins.routes.addUserClass
import com.example.plugins.routes.configureRouting
import com.example.plugins.routes.databaseCollection
import io.ktor.application.*
import io.ktor.features.*

fun main() {

    embeddedServer(Netty, port = 8083, host = "127.0.0.1") {
        databaseCollection()
        configureRouting()
        model()
        addUserClass()
    }.start(wait = true)
}
