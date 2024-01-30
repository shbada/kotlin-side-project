package com.studyolle.account.application

import com.studyolle.account.domain.AccountLoginService
import com.studyolle.account.domain.AccountService
import org.springframework.stereotype.Service

@Service
class AccountLoginFacade(
    private val accountLoginService: AccountLoginService
) {
    fun findAll(): Any {
        return accountLoginService.findAll()
    }

}