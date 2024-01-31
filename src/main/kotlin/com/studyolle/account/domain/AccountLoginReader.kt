package com.studyolle.account.domain

import com.studyolle.account.domain.entity.AccountLogin

interface AccountLoginReader {
    fun findAll(): MutableList<AccountLogin>
}