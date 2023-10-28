package com.studyolle.account.infrastructure

import com.studyolle.account.domain.AccountReader
import org.springframework.stereotype.Component

@Component
class AccountReaderImpl(
    private val accountRepository: AccountRepository
): AccountReader {
}