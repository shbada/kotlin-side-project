package com.studyolle.account.domain

import com.studyolle.account.domain.entity.Account

interface AccountStore {
    fun saveNewAccount(account: Account): Account
}