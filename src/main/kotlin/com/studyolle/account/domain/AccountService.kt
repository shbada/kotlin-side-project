package com.studyolle.account.domain

import com.studyolle.account.domain.command.AccountCommand
import com.studyolle.account.domain.entity.Account
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountStore: AccountStore,
    private val passwordEncoder: PasswordEncoder,
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    /**
     * 회원가입
     */
    fun processNewAccount(signUpForm: AccountCommand.SignUpForm) {
        /* 신규 회원 저장 */
        saveNewAccount(signUpForm)
    }

    private fun saveNewAccount(signUpForm: AccountCommand.SignUpForm) {
        /* password set */
        signUpForm.password = passwordEncoder.encode(signUpForm.password)

        /* account entity */
        val account: Account = signUpForm.toEntity()
        accountStore.saveNewAccount(account)
    }
}