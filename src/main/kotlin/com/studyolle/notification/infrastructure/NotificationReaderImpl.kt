package com.studyolle.study.infrastructure

import com.studyolle.study.domain.NotificationReader
import org.springframework.stereotype.Component

@Component
class NotificationReaderImpl(
    private val notificationRepository: NotificationRepository
) : NotificationReader {

}