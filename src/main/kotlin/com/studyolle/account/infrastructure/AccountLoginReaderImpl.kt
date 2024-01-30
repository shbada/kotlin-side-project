package com.studyolle.account.infrastructure

import com.studyolle.account.domain.AccountLoginReader
import com.studyolle.account.domain.AccountReader
import org.springframework.stereotype.Component

@Component
class AccountLoginReaderImpl(
    private val accountLoginRepository: AccountLoginRepository
): AccountLoginReader {
    override fun findAll(): Any {
        return accountLoginRepository.findAll()
    }

}