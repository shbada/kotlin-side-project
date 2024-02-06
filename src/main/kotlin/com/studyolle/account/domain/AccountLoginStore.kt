package com.studyolle.account.domain

import com.studyolle.account.domain.entity.AccountLogin

interface AccountLoginStore {
    fun registerAccountLogin(accountLogin: AccountLogin)
}