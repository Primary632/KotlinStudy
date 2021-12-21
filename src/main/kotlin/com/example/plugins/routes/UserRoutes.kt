package com.example.plugins.routes


import com.example.plugins.controllers.UserController
import com.example.plugins.entities.UserEntity
import com.example.plugins.entities.repositries.UserRepositries
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
        selectUserById()
        addUsers()
        userSort()
        updateUserName()
    }
}

fun Route.addUsers(){
    post("/user/add"){
        var user = call.receive<UserEntity>()
        val addOneUser = userController?.addOneUser(user)
        call.respondText { "新增学生成功，学生ID为：${addOneUser}" }
    }
}
fun Route.userSort(){
    get("/user/sort"){

        userController?.let { it1 -> call.respond(it1.userSort()) }

    }
}

fun Route.updateUserName(){
    post(){

    }
}

fun Route.selectUserById(){
    route("/user/{id}"){
        var id2:String?=null
        get{
            if (call.parameters["id"]!=null){
               id2 = call.parameters["id"];
            }
            val userRepositries = UserRepositries()

            val userList = userRepositries.userSorts()

                call.respond(userList)

//            call.respond(user);
//            print(user)

        }
    }
}