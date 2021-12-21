package com.example.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*


//需要安装的插件
fun Application.model(){
    //可以用来接受前端传过来的json串
    install(ContentNegotiation){
        gson()
    }
}








//fun Route.tete(){
//    route("/test"){
//        route("/customer/{id?}"){
//            get{
//                if(call.parameters["id"]=="123"){
//                    println("你输入的ID为："+call.parameters["id"])
//                    call.respondText(" "+call.parameters["id"])
//                }
//            }
//            post {
//
//            }
//        }
//    }
//
//}
