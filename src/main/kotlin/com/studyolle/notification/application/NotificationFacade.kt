package com.studyolle.study.application

import com.studyolle.study.domain.NotificationService
import org.springframework.stereotype.Service

@Service
class NotificationFacade(
    private val notificationService: NotificationService,
) {

}