package com.studyolle.account.application

import com.studyolle.account.domain.AccountService
import com.studyolle.account.domain.command.AccountCommand
import com.studyolle.account.interfaces.dto.AccountDto
import org.springframework.stereotype.Service

@Service
class AccountFacade(
    private val accountService: AccountService,
) {
    fun processNewAccount(signUpForm: AccountCommand.SignUpForm) {
        accountService.processNewAccount(signUpForm)
    }

    fun checkEmailToken(email: String, token: String) {
        accountService.checkEmailToken(email, token)
    }

    fun reSendSignUpConfirmEmail(email: String) {
        accountService.reSendSignUpConfirmEmail(email)
    }

    fun getAccountInfo(nickname: String, email: String) {
        accountService.getAccountInfo(nickname, email)
    }

    fun updatePassword(passwordForm: AccountDto.PasswordForm) {
        accountService.updatePassword(passwordForm);
    }
}