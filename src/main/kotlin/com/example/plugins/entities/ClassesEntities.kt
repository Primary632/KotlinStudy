package com.example.plugins.entities


import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

/**
 * @program  ktor-sample
 * @description
 * @author 空城
 * @date 2021-12-20 15:02
 **/
object ClassesTable : IntIdTable(name = "classes") {
    var classname = varchar("classname", 30);
    var classNum = integer("classNum").uniqueIndex();
}

data class ClassEntity(
    val id: Int? = null,
    var classname: String? = null,
    var classNum: Int? = null
) {
    companion object {
        fun getRow(row: ResultRow) = ClassEntity(
            id = row[ClassesTable.id].value,
            classname = row[ClassesTable.classname],
            classNum = row[ClassesTable.classNum]
        )
    }

}