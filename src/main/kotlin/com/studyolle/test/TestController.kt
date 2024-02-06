package com.studyolle.test

import com.studyolle.common.response.CommonResponse
import com.studyolle.common.response.ResponseDto
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/test")
class TestController(
    private val redisTemplate: RedisTemplate<String, String>
) {
    @PostMapping("/redis")
    fun addRedisKey(): ResponseEntity<ResponseDto<Void>> {
        val vop = redisTemplate.opsForValue()
        vop.set("test1", "1")
        vop.set("test2", "2")
        vop.set("test3", "3")

        return CommonResponse.send()
    }

    @GetMapping("/redis/{key}")
    fun getRedisKey(@PathVariable key: String): ResponseEntity<ResponseDto<String?>> {
        val vop = redisTemplate.opsForValue()
        val value = vop.get(key)

        return CommonResponse.send(value)
    }
}