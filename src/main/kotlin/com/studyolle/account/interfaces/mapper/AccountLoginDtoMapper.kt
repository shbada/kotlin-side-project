package com.studyolle.account.interfaces.mapper

import com.studyolle.account.domain.command.AccountLoginCommand
import com.studyolle.account.interfaces.dto.AccountLoginDto
import com.studyolle.study.domain.command.StudyCommand
import com.studyolle.study.interfaces.dto.StudyDto

class AccountLoginDtoMapper {
    companion object {
        fun of(accountLoginCommand: AccountLoginCommand): AccountLoginDto =
            AccountLoginDto(
                nickname = accountLoginCommand.nickname,
            )

        fun of(registerForm: AccountLoginDto.RegisterForm): AccountLoginCommand.RegisterForm =
            AccountLoginCommand.RegisterForm(
                nickname = registerForm.nickname,
            )
    }
}