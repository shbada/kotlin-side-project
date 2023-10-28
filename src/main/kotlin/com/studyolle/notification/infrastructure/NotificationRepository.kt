package com.studyolle.study.infrastructure

import com.studyolle.study.domain.entity.Notification
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository: JpaRepository<Notification, Long> {
}