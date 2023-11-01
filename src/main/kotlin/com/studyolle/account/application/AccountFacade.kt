package com.studyolle.account.application

import com.studyolle.account.domain.AccountService
import com.studyolle.account.domain.command.AccountCommand
import org.springframework.stereotype.Service

@Service
class AccountFacade(
    private val accountService: AccountService,
) {
    fun processNewAccount(signUpForm: AccountCommand.SignUpForm) {
        accountService.processNewAccount(signUpForm);
    }

    fun checkEmailToken(email: String, token: String) {
        accountService.checkEmailToken(email, token);
    }
}