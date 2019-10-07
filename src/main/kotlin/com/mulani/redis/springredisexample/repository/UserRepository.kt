package com.mulani.redis.springredisexample.repository

import com.mulani.redis.springredisexample.model.User

interface UserRepository {

    fun getAllUsers(): List<User>

    fun getUser(name:String):User?

    fun addUser(user:User):User
}