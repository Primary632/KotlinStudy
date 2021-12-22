package com.example.plugins.services

import com.example.plugins.entities.ClassEntity
import com.example.plugins.entities.repositries.ClassRepositries
import org.jetbrains.exposed.dao.id.EntityID

/**
 * @program  ktor-sample
 * @description
 * @author 空城
 * @date 2021-12-21 12:09
 **/
class UserClassesService {
  private  val  userClassRepositries =ClassRepositries()
    fun addOneClass(userClass: ClassEntity): EntityID<Int> {
        return  userClassRepositries.addClass(userClass)
    }

    fun selectClassById(id: Int): List<ClassEntity> {
      return userClassRepositries.selectClassById(id)
    }

  fun updateClass(classes: ClassEntity): Int {
    return  userClassRepositries.updateClass(classes)
  }

  fun deleteClassById(id: Int): Int {
    return userClassRepositries.deleteClass(id)
  }

}