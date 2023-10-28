package com.studyolle.study.domain

import org.springframework.stereotype.Service

@Service
class NotificationService(
    private val notificationStore: NotificationStore,
    private val notificationReader: NotificationReader
) {

}