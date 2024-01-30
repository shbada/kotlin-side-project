package com.studyolle.account.infrastructure

import com.studyolle.account.domain.AccountLoginStore
import org.springframework.stereotype.Component

@Component
class AccountLoginStoreImpl(
    private val accountLoginRepository: AccountLoginRepository
): AccountLoginStore {

}