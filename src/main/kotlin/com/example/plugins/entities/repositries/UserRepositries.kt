package com.example.plugins.entities.repositries


import com.example.plugins.entities.Users
import com.example.plugins.entities.UserEntity
import com.example.plugins.entities.UserDao
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


class UserRepositries {

    //添加学生
    fun addUser(user: UserEntity?): EntityID<Int> {

        val userId = transaction {
            //打印日志
            //addLogger(StdOutSqlLogger)
            SchemaUtils.create(Users)
            Users.insertAndGetId {
                if (user != null) {
                    it[name] = user.name!!
                    it[sex] = user.sex!!
                    it[address] = user.address!!
                    it[classId] = user.classId!!
                }
            }

        }
        return userId;
    }

    //排序
    fun userSorts(): List<UserEntity> {
        return transaction {
            Users.selectAll().map { UserEntity.fromRow(it) }
        }
    }
//fun userList
//fun selectAllUsers
//fun getAllUsers
//fun updateUserById

    //根据学生ID查找学生
    fun selectOneUserById(id: String): List<UserEntity> {
        val user = transaction {
            //SchemaUtils.create(User)
            Users.select { Users.id eq id.toInt() }.map {
                UserEntity.fromRow(it)
            }
        }
        return user
    }

    //修改学生信息 根据ID
    fun updateUser(user: UserEntity?) {


        transaction {
            if (user != null) {
                addLogger(StdOutSqlLogger)
                Users.update({ Users.id eq user.id }) {
                    it[name] = user.name!!
                    it[address] = user.address!!
                }

            }
        }

    }

    fun deleteUserById(id: Int): Int {
       var user= transaction {
            Users.deleteWhere { Users.id eq id }
        }

           return user
    }
}
