package com.studyolle.common.entity

import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @CreationTimestamp
    var createdAt: ZonedDateTime = ZonedDateTime.now()

    @CreatedBy
    var createdBy: String = "SYSTEM_PROPERTY_AUTHOR"

    @UpdateTimestamp
    var lastModifiedAt: ZonedDateTime = ZonedDateTime.now()

    @LastModifiedBy
    var lastModifiedBy: String = SYSTEM_PROPERTY_AUTHOR
}

private const val SYSTEM_PROPERTY_AUTHOR = "system"