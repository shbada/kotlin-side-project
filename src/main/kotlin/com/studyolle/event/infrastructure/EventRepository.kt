package com.studyolle.event.infrastructure

import com.studyolle.event.domain.entity.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository: JpaRepository<Event, Long> {
}