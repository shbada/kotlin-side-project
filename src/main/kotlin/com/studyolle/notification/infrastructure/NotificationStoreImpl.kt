package com.studyolle.study.infrastructure

import com.studyolle.study.domain.NotificationStore
import org.springframework.stereotype.Component

@Component
class NotificationStoreImpl(
    private val notificationRepository: NotificationRepository
) : NotificationStore {
}