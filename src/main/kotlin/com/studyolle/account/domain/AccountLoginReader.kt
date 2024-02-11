package com.studyolle.account.domain

import com.studyolle.account.domain.entity.AccountLogin
import java.util.*

interface AccountLoginReader {
    fun findAll(): MutableList<AccountLogin>
    fun findById(accountLoginIdx: Long): Optional<AccountLogin>
}