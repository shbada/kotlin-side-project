package com.studyolle.account.infrastructure

import com.studyolle.account.domain.entity.Account
import com.studyolle.account.domain.AccountStore
import org.springframework.stereotype.Component

@Component
class AccountStoreImpl(
    private val accountRepository: AccountRepository
): AccountStore {
    override fun saveNewAccount(account: Account): Account {
        return accountRepository.save(account)
    }

    override fun findByEmail(email: String): Account {
        return accountRepository.findByEmail(email)
    }

    override fun findByNickname(nickname: String): Account {
        return accountRepository.findByNickname(nickname)
    }
}