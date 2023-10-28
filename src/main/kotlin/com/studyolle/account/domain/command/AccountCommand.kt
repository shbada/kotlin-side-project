package com.studyolle.account.domain.command

import com.studyolle.account.domain.entity.Account

class AccountCommand {
    data class SignUpForm(
        val nickname: String,
        val email: String,
        var password: String, // setter
    ) {
        fun toEntity() = Account(
            nickname = nickname,
            email = email,
            password = password,
        )
    }
}