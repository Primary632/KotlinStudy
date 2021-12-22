package com.example.plugins.routes


import com.example.plugins.controllers.UserController
import com.example.plugins.entities.UserEntity
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


data class UserForm(
    val id:Int? = null,
    val name:String? = null,
    val age:Int,
)

var userController: UserController? = UserController()
fun Application.configureRouting() {

    routing{
        get("/") {
            call.respondText("Hello World!")
        }
        //user/1   user?id=1
        route("/user"){
            selectUserById()
            addUsers()
            userSort()
            updateUserName()
            deleteUSerById()
        }

    }
}

fun Route.addUsers(){
    post("/add"){
        var user = call.receive<UserEntity>()
        val addOneUser = userController?.addOneUser(user)
        call.respondText { "新增学生成功，学生ID为：${addOneUser}" }

    }
}
fun Route.userSort(){
    get("/sort"){

        userController?.let { it1 -> call.respond(it1.userSort()) }
    }
}

fun Route.updateUserName(){
    put {
        val user = call.receive<UserEntity>()
        userController?.updateUser(user,call)
    }


}

fun Route.selectUserById(){
    route("/{id}"){
        var id2:String?=null
        get{
            if (call.parameters["id"]!=null){
               id2 = call.parameters["id"];
            }
            userController?.selectOneUserById(id2,call)
        }
    }
}

fun Route.deleteUSerById(){
    delete ("/{id?}") {
        //val name = call.request.queryParameters["name"] ?: throw Exception("should not be null")
        val id = call.parameters["id"]?.toInt()
        if (id != null) {
            userController?.deleteUserById(id, call)
        } else {
            call.respond("Sorry， you don't input a null value.")
            throw Exception("id is null value ")
        }
    }
}