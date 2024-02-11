package com.studyolle.account.infrastructure

import com.studyolle.account.domain.entity.AccountLogin
import org.springframework.data.mongodb.repository.MongoRepository

interface AccountLoginRepository : MongoRepository<AccountLogin, Long> {
}