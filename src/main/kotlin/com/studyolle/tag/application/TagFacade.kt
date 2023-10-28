package com.studyolle.tag.application

import com.studyolle.tag.domain.TagService
import com.studyolle.tag.domain.command.TagCommand
import org.springframework.stereotype.Service

@Service
class TagFacade(
    private val tagService: TagService
) {
    fun registerTag(tagCommand: TagCommand.RegisterForm) {
        tagService.registerTag(tagCommand)
    }

}