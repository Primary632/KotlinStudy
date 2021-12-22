package com.example.plugins.controllers

import com.example.plugins.entities.ClassEntity
import com.example.plugins.services.UserClassesService
import com.example.plugins.services.UserService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*


class UserClassController {
    private val userCLassService = UserClassesService()

    suspend fun addClass(call: ApplicationCall) {
        val userClass = call.receive<ClassEntity>()
        if (userClass.classname != null||userClass.classname!="" && userClass.classNum != null) {
            val id = userCLassService.addOneClass(userClass)
            call.respond(HttpStatusCode.OK, "Add team successful，it's id is $id")
        } else {
            call.respond("The value cannot be null")
            throw NullPointerException("A null value appeared when adding a team ")
        }
    }

    suspend fun selectClassById(call: ApplicationCall) {
        val id = call.parameters["id"]?.toInt()
        if (id != null) {
            val classes: List<ClassEntity> = userCLassService.selectClassById(id)
            if (classes.isNotEmpty())
                call.respond(classes)
            else
                call.respond("Sorry,the id you're look for is not exist")

        } else {
            call.respond("The value of id cannot  be empty")
            throw NullPointerException("When querying user class by id ， id is null ")
        }
    }

    suspend fun updateClass(call: ApplicationCall) {
        val classes = call.receive<ClassEntity>()

        val i = userCLassService.updateClass(classes)
        if (i > 0) {
            call.respond(HttpStatusCode.OK, "Modify the success")
        } else {
            call.respond(HttpStatusCode.NotModified, "Failed to modify")
        }

    }

    suspend fun deleteClassById(call: ApplicationCall) {
        val id = call.parameters["id"]?.toInt()
        if (id != null) {
            val i = userCLassService.deleteClassById(id)
            if (i > 0) {
                call.respond(HttpStatusCode.OK, "delete team success")
            } else {
                call.respond(HttpStatusCode.NotModified, "Failed to delete")
            }
        } else {
            call.respond("Id cannot is null")
            throw NullPointerException("When delete user class by id ，id is null ")
        }
    }
}
