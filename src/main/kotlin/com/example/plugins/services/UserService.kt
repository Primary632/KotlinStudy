package com.example.plugins.services

import com.example.plugins.entities.UserEntity
import com.example.plugins.entities.UserDao
import com.example.plugins.entities.repositries.UserRepositries
import org.jetbrains.exposed.dao.id.EntityID

/**
 * @program  ktor-sample
 * @description
 * @author 空城
 * @date 2021-12-21 12:09
 **/
class UserService {

    private val userRepo:UserRepositries = UserRepositries()

    fun addOneUser(userEt: UserEntity?): EntityID<Int> {
        return userRepo.addUser(userEt)
    }

    fun sortUser(): List<UserEntity> {
        return userRepo.userSorts()
    }
}