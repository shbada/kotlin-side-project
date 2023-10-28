package com.studyolle.account.interfaces.mapper

import com.studyolle.account.domain.command.AccountCommand
import com.studyolle.account.interfaces.dto.AccountDto

class AccountDtoMapper {
    companion object {
        fun of(signUpForm: AccountDto.SignUpForm): AccountCommand.SignUpForm =
            AccountCommand.SignUpForm(
                nickname = signUpForm.nickname,
                email = signUpForm.email,
                password = signUpForm.password
            )
    }
}