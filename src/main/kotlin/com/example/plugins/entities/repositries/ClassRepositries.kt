package com.example.plugins.entities.repositries

import com.example.plugins.entities.ClassEntity
import com.example.plugins.entities.ClassesTable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

/**
 * @program  ktor-sample
 * @description
 * @author 空城
 * @date 2021-12-20 15:33
 **/
class ClassRepositries {
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

    fun updateClass(classData: ClassEntity): Int {
        return transaction {
            ClassesTable.update({ ClassesTable.id eq classData.id }) {
                it[classname] = classData.classname!!
                it[classNum] = classData.classNum!!
            }
        }

    }

    fun selectClassById(id: Int): List<ClassEntity> {
        return transaction {
            ClassesTable.select { ClassesTable.id eq id }.map {
                ClassEntity.getRow(it)
            }
        }

    }

    fun deleteClass(id: Int):Int{
       return transaction {
            ClassesTable.deleteWhere {
                ClassesTable.id eq id
            }
        }
    }
}
