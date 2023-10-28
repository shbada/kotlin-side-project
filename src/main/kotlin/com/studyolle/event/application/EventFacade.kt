package com.studyolle.event.application

import com.studyolle.event.domain.EventService
import org.springframework.stereotype.Service

@Service
class EventFacade(
    private val eventService: EventService
) {

}