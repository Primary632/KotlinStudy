package com.example.plugins.entities.repositries
import com.example.plugins.entities.ClassEntity
import com.example.plugins.entities.ClassesTable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * @program  ktor-sample
 * @description
 * @author 空城
 * @date 2021-12-20 15:33
 **/
//添加班级
fun addClass(classData: ClassEntity): EntityID<Int> {
    val id = transaction {
        //addLogger(StdOutSqlLogger)
        ClassesTable.insertAndGetId {
            it[classname] = classData.classname!!
            it[classNum] = classData.classNum!!
        }
    }
    return id
}