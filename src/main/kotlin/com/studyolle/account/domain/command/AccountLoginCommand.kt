package com.studyolle.account.domain.command

import com.studyolle.account.domain.entity.AccountLogin

class AccountLoginCommand(
    var nickname: String
) {
    data class RegisterForm(
        val nickname: String,
    ) {
        fun toEntity() = AccountLogin(
            nickname = nickname,
        )
    }
}