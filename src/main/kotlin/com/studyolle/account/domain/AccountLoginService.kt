package com.studyolle.account.domain

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AccountLoginService(
    private val accountLoginReader: AccountLoginReader,
    private val accountLoginStore: AccountLoginStore
) {
    fun findAll(): Any {
        return accountLoginReader.findAll()
    }

    private val log = LoggerFactory.getLogger(this::class.java)


}