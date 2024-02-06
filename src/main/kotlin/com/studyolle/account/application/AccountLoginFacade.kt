package com.studyolle.account.application

import com.studyolle.account.domain.AccountLoginService
import com.studyolle.account.domain.command.AccountLoginCommand
import org.springframework.stereotype.Service

@Service
class AccountLoginFacade(
    private val accountLoginService: AccountLoginService
) {
    fun findAll(): MutableList<AccountLoginCommand> {
        return accountLoginService.findAll()
    }

    fun registerAccountLogin(registerForm: AccountLoginCommand.RegisterForm) {
        accountLoginService.registerAccountLogin(registerForm)
    }

}