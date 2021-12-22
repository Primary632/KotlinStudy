package com.example.plugins


import io.ktor.application.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.internal.Classes

/**
 * @program  ktor-sample
 * @description 数据库操作文件
 * @author 空城
 * @date 2021-12-17 10:24
 **/
const val URL: String =
    "jdbc:mysql://localhost:3306/KotlinTest?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
const val DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
fun Application.databaseCollection() {
    Database.connect(
        URL, driver = DRIVER_CLASS,
        user = "root", password = "123456"
    );
}
//测试
//fun database() {
//    transaction {
//        addLogger(StdOutSqlLogger)
//        SchemaUtils.create(User)
//        Users.new {
//            name = "测试"
//            sex = 0
//            address = "上海"
//            classId = 1
//        }
//    }
//    transaction {
//        addLogger(StdOutSqlLogger)
//        SchemaUtils.create(classes)
//        Class.new {
//            classname = "计算机科学"
//            classNum = 111
//        }
//    }
//}



//添加学生
//fun addUser(user: UsersData?): Users {
//
//    val user = transaction {
//        //打印日志
//        addLogger(StdOutSqlLogger)
//        SchemaUtils.create(User)
//        Users.new {
//            if (user != null) {
//                name = user.name
//                sex = user.sex
//                address = user.address
//                classId = user.classId
//            }
//        }
//
//    }
//
//    return user;
//}

//添加班级
//fun addClass(classData:ClassData?){
//    transaction {
//        addLogger(StdOutSqlLogger)
//        Class.new{
//            if(classData!=null){
//                classname=classData.classname
//                classNum=classData.classNum
//            }
//        }
//    }
//}

//根据学生ID查找学生
//fun selectOneUserById(id: String): Users? {
//    var user=transaction {
//        //SchemaUtils.create(User)
//         Users.findById(id.toInt());
//    }
//    return user
//}
//排序
//fun userSorts():List<Users>{
//
//    var users= transaction {
//         Users.all().sortedByDescending{ it.id }
//    }
//
//    return users
//}


//根据学生的班级ID查找学生所在的班级

//删除学生信息 ID

//
//




//object classes : IntIdTable() {
//    val classname = varchar("classname", 30);
//    val classNum = integer("classNum").uniqueIndex();
//}
//
//
//class Class(id: EntityID<Int>) : IntEntity(id) {
//    companion object : IntEntityClass<Class>(classes)
//    var classname by classes.classname
//    var classNum by classes.classNum
//}
//
//data class UsersData(val id: Int, val name: String, val address: String, val sex: Int, val classId: Int)
////dsl dataclass //table
////dao entity
//
//data class ClassData(val id:Int,val classname:String,val classNum:Int)