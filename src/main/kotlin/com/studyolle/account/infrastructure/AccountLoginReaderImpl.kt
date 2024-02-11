package com.studyolle.account.infrastructure

import com.studyolle.account.domain.AccountLoginReader
import com.studyolle.account.domain.AccountReader
import com.studyolle.account.domain.command.AccountLoginCommand
import com.studyolle.account.domain.entity.AccountLogin
import org.springframework.stereotype.Component
import java.util.*

@Component
class AccountLoginReaderImpl(
    private val accountLoginRepository: AccountLoginRepository
): AccountLoginReader {
    override fun findAll(): MutableList<AccountLogin> {
        return accountLoginRepository.findAll()
    }

    override fun findById(accountLoginIdx: Long): Optional<AccountLogin> {
        return accountLoginRepository.findById(accountLoginIdx)
    }

}