package com.studyolle.event.infrastructure

import com.studyolle.event.domain.EventStore
import org.springframework.stereotype.Component

@Component
class EventStoreImpl(
    private val eventRepository: EventRepository
) : EventStore {
}