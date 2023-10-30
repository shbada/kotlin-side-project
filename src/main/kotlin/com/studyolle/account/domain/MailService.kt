package com.studyolle.account.domain

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MailService(
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun sendEmail(message: String) {
        log.info("sent email: {}", message)
    }
}