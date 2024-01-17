package com.studyolle.account.infrastructure

import com.studyolle.account.domain.AccountReader
import com.studyolle.account.domain.entity.Account
import org.springframework.stereotype.Component

@Component
class AccountReaderImpl(
    private val accountRepository: AccountRepository
): AccountReader {
    override fun findByEmail(email: String): Account {
        return accountRepository.findByEmail(email)
    }

    override fun findByNickname(nickname: String): Account {
        return accountRepository.findByNickname(nickname)
    }
}