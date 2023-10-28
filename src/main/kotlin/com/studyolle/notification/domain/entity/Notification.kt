package com.studyolle.study.domain.entity

import com.studyolle.account.domain.entity.Account
import com.studyolle.common.entity.BaseEntity
import com.studyolle.notification.domain.entity.enums.NotificationType
import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "notification")
@Entity
class Notification(
    @Id @GeneratedValue
    private var id: Long? = null,

    private val title: String? = null,

    private val link: String? = null,

    private val message: String? = null,

    private val checked: Boolean = false,

    @ManyToOne
    private val account: Account? = null,

    private val createdDateTime: LocalDateTime? = null,

    @Enumerated(EnumType.STRING)
    private val notificationType: NotificationType? = null,
) : BaseEntity() {

}