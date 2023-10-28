package com.studyolle.event.domain.entity

import com.studyolle.account.domain.entity.Account
import com.studyolle.common.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import lombok.EqualsAndHashCode
import lombok.Getter
import lombok.Setter
import java.time.LocalDateTime

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = ["id"])
class Enrollment (
    @Id
    @GeneratedValue
    private val id: Long? = null,

    /* 테이블 enrollment : 컬럼 event_id */
    @ManyToOne
    private val event: Event? = null,

    /* 테이블 enrollment : 컬럼 account_id */
    @ManyToOne
    private val account: Account? = null,
    private val enrolledAt: LocalDateTime? = null,
    private val accepted: Boolean = false,
    private val attended: Boolean = false,
) : BaseEntity() {

}
