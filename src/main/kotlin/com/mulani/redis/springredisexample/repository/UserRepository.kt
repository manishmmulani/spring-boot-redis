package com.mulani.redis.springredisexample.repository

import com.mulani.redis.springredisexample.model.User
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class UserRepository {
    val users = arrayListOf(User("Manish", 31, BigDecimal.valueOf(1000)),
            User("Preeti", 31, BigDecimal.ZERO));

    fun getAllUsers(): List<User> {
        return users;
    }

    fun getUser(name:String):User? {
        return users.filter { it.name == name }.firstOrNull()
    }

    fun addUser(user:User):User{
        val existingUser = getUser(user.name)
        if (existingUser != null) {
            return existingUser
        }

        users.add(user);
        return user;
    }
}