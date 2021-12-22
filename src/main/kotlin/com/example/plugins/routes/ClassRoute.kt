package com.example.plugins.routes

import com.example.plugins.controllers.UserClassController
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
val classController: UserClassController = UserClassController()
fun Application.addUserClass() {
    routing {
        route("/classes") {
            addClasses()
        }

    }
}

fun Route.addClasses() {
    // /user   get  post put  delete
    get("/{id?}") {
        classController.selectClassById(call)
    }
    post {
        classController.addClass(call)
    }
    put {
        classController.updateClass(call)
    }
    delete("/{id?}") {
        classController.deleteClassById(call)
    }
}
