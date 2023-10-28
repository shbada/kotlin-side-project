package com.studyolle.event.infrastructure

import com.studyolle.event.domain.EventReader
import org.springframework.stereotype.Component

@Component
class EventReaderImpl(
    private val eventRepository: EventRepository
) : EventReader {
}