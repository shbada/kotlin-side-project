package com.studyolle.event.domain.entity

import com.eventserver.domain.enums.EventType
import com.studyolle.common.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "event")
@Entity
class Event (
    @Id
    @GeneratedValue
    private var id: Long? = null,

    @Column(nullable = false)
    private val title: String? = null,

    @Lob
    private val description: String? = null,

    @Column(nullable = false)
    private val createdDateTime: LocalDateTime? = null,

    @Column(nullable = false)
    private val endEnrollmentDateTime: LocalDateTime? = null,

    @Column(nullable = false)
    private val startDateTime: LocalDateTime? = null,

    @Column(nullable = false)
    private val endDateTime: LocalDateTime? = null,

    private val limitOfEnrollments: Int? = null,

    @Enumerated(EnumType.STRING)
    private val eventType: EventType? = null
) : BaseEntity() {

}