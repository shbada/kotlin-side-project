package com.studyolle.account.infrastructure

import com.studyolle.account.domain.entity.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long> {
    fun findByEmail(email: String): Account
    fun findByNickname(nickname: String): Account
}