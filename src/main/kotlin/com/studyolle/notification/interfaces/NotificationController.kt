package com.studyolle.study.interfaces

import com.studyolle.study.application.NotificationFacade
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/notification")
class NotificationController(
    private val notificationFacade: NotificationFacade,
) {

}