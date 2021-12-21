package com.example.plugins.entities

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

/**
 * @program  ktor-sample
 * @description
 * @author 空城
 * @date 2021-12-20 15:01
 **/
object Users : IntIdTable("User") {
    val  name = varchar("name", 50)
    val sex = integer("sex")
    val address = varchar("address", 50);
    val classId = integer("classid")
}

class UserDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserDao>(Users)
    var name by Users.name
    var address by Users.address
    var sex by Users.sex
    var classId by Users.classId
}

@Serializable
data class UserEntity(
    val id :Int?= null,
    var name : String ?= null,
    var address : String ?= null,
    var sex : Int ?= null,
    var classId : Int ?= null
){
    companion object{
        fun fromRow(row : ResultRow)=UserEntity(//Row
            id = row[Users.id].value,
            name = row[Users.name],
            address = row[Users.address],
            sex = row[Users.sex],
            classId = row[Users.classId]
        )


    }
}