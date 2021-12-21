package com.example.plugins.routes

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database

/**
 * @program  ktor-sample
 * @description
 * @author 空城
 * @date 2021-12-20 15:03
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