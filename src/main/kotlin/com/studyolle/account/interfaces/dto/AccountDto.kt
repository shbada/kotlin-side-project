package com.studyolle.account.interfaces.dto

class AccountDto {
    data class SignUpForm(
        var nickname: String,
        val email: String,
        val password: String,
    )

    data class PasswordForm(
            val email: String,
            val password: String,
    )
}