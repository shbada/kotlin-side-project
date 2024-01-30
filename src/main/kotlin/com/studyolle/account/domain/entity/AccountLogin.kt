package com.studyolle.account.domain.entity

import jakarta.persistence.Id
import lombok.Getter
import lombok.Setter
import org.springframework.data.mongodb.core.mapping.Document

@Getter
@Setter
@Document(collection = "account_login")
class AccountLogin(
    @Id
    val _id: String,
    val nickname: String? = null
) {

}