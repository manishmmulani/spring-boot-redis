package com.mulani.redis.springredisexample.repository

import com.mulani.redis.springredisexample.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component("redisRepo")
class RedisUserRepository(@Autowired var redisTemplate: RedisTemplate<String, User>) : UserRepository {

    val hashOps = redisTemplate.opsForHash<String, User>()
    val REDIS_DS_KEY = "USER"

    override fun getAllUsers(): List<User> {
        val userMap = hashOps.entries(REDIS_DS_KEY)
        return ArrayList(userMap.values);
    }

    override fun getUser(name:String): User? {
        return hashOps.get(REDIS_DS_KEY, name)
    }

    override fun addUser(user: User): User {
        hashOps.put(REDIS_DS_KEY, user.name, user)
        return user
    }
}