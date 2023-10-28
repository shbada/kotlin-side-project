package com.studyolle.event.domain

import org.springframework.stereotype.Service

@Service
class EventService(
    private val eventStore: EventStore
) {

}