package com.example.plugins.routes

import com.example.plugins.entities.ClassEntity
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.routing.*

/**
 * @program  ktor-sample
 * @description
 * @author 空城
 * @date 2021-12-20 16:42
 **/

fun Application.addUserClass(){
    routing{
        route("/classes"){
            addClasses()
        }

    }
}
fun Route.addClasses(){
    // /user   get  post put  delete
    get{
        val userClass = call.receive<ClassEntity>()

    }
    post{

    }

    delete {

    }
}
