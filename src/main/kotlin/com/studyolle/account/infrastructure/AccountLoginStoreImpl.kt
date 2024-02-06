package com.studyolle.account.infrastructure

import com.studyolle.account.domain.AccountLoginStore
import com.studyolle.account.domain.entity.AccountLogin
import org.springframework.stereotype.Component

@Component
class AccountLoginStoreImpl(
    private val accountLoginRepository: AccountLoginRepository
): AccountLoginStore {
    override fun registerAccountLogin(accountLogin: AccountLogin) {
        accountLoginRepository.save(accountLogin)
    }

}