package com.example.plugins.controllers

import com.example.plugins.entities.UserEntity
import com.example.plugins.entities.UserDao
import com.example.plugins.services.UserService
import org.jetbrains.exposed.dao.id.EntityID

/**
 * @program  ktor-sample
 * @description 用户
 * @author 空城
 * @date 2021-12-20 18:45
 **/
class UserController {
    private val userService:UserService= UserService()
    //添加用户
    fun creatUser(user:UserEntity){

    }

    fun addOneUser(user: UserEntity?) : EntityID<Int> {
        var userEt:UserEntity? =null
        if (user != null) {
            if (userEt != null) {
                userEt.name= if (user.name!=null) user.name else ""
                userEt.address = if(user.address !=null) user.address else ""
                userEt.sex = if(user.sex !=null) user.sex else null
                userEt.classId = if(user.classId !=null) user.classId else null

            }
        }
       return  userService.addOneUser(userEt)
    }

    fun userSort(): List<UserEntity> {
       return userService.sortUser()
    }

}