package com.mulani.redis.springredisexample.config

import com.mulani.redis.springredisexample.model.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig {
    @Value("\${redis.server.host}")
    lateinit var redisServerHost:String
    @Value("\${redis.server.port}")
    var redisServerPort:Int = 0

    @Bean
    fun getRedisConnectionFactory():RedisConnectionFactory {
        val config = RedisStandaloneConfiguration(redisServerHost, redisServerPort)
        return LettuceConnectionFactory(config)
    }

    @Bean
    fun getRedisTemplateForUser():RedisTemplate<String, User> {
        val template = RedisTemplate<String, User>()
        template.setConnectionFactory(getRedisConnectionFactory())
        return template
    }
}