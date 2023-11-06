package com.studyolle.tag.application

import com.studyolle.tag.domain.TagService
import com.studyolle.tag.domain.command.TagCommand
import com.studyolle.zone.domain.command.ZoneCommand
import org.springframework.stereotype.Service

@Service
class TagFacade(
    private val tagService: TagService
) {
    fun registerTag(tagCommand: TagCommand.RegisterForm) {
        tagService.registerTag(tagCommand)
    }

    fun deleteTag(title: String) {
        tagService.deleteTag(title)
    }

    fun getTagList(): MutableList<TagCommand> {
        return tagService.getTagList()
    }

}