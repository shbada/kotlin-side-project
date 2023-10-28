package com.studyolle.event.interfaces

import com.studyolle.event.application.EventFacade
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/event")
class EventController(
    private val eventFacade: EventFacade
) {

}