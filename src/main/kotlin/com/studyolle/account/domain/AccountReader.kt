package com.studyolle.account.domain

import com.studyolle.account.domain.entity.Account

interface AccountReader {
    fun findByEmail(email: String): Account
    fun findByNickname(nickname: String): Account
}