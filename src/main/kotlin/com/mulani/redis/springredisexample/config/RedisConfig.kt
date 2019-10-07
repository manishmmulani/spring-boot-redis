package com.mulani.redis.springredisexample.config

import com.mulani.redis.springredisexample.model.User
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig {
    @Bean
    fun getRedisConnectionFactory():RedisConnectionFactory {
        val config = RedisStandaloneConfiguration("localhost", 6379)
        return LettuceConnectionFactory(config)
    }

    @Bean
    fun getRedisTemplateForUser():RedisTemplate<String, User> {
        val template = RedisTemplate<String, User>()
        template.setConnectionFactory(getRedisConnectionFactory())
        return template
    }
}