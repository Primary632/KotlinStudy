package com.example

import com.example.plugins.routes.configureRouting
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.After
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
    @org.junit.Test
    fun test(){
        println("hello")
    }



}