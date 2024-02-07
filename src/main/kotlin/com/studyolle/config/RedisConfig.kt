package com.studyolle.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer
import org.springframework.context.annotation.Primary

/**
# redis-cli -p 6379
127.0.0.1:6379> keys *
127.0.0.1:6379>
 */
@Configuration
class RedisConfig {

    @Value("\${spring.data.redis.host}")
    private val host: String = "127.0.0.1:6379"

    @Value("\${spring.data.redis.port}")
    private val port: Int = 0

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        val redisConfiguration = RedisStandaloneConfiguration()
        redisConfiguration.hostName = host
        redisConfiguration.port = port

        return LettuceConnectionFactory(redisConfiguration)
    }

    @Primary
    @Bean
    fun redisTemplate(): RedisTemplate<String, String> {
        val redisTemplate = RedisTemplate<String, String>()
        redisTemplate.connectionFactory = redisConnectionFactory()
        redisTemplate.keySerializer = StringRedisSerializer()
        redisTemplate.valueSerializer = StringRedisSerializer()

        return redisTemplate
    }
}
