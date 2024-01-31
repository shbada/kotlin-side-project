package com.studyolle.account.interfaces.mapper

import com.studyolle.account.domain.command.AccountLoginCommand
import com.studyolle.account.interfaces.dto.AccountLoginDto

class AccountLoginDtoMapper {
    companion object {
        fun of(accountLoginCommand: AccountLoginCommand): AccountLoginDto =
            AccountLoginDto(
                nickname = accountLoginCommand.nickname,
            )
    }
}