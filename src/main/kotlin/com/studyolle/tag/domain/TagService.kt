package com.studyolle.tag.domain

import com.studyolle.common.exception.BadRequestException
import com.studyolle.common.exception.ErrorMessage
import com.studyolle.tag.domain.command.TagCommand
import com.studyolle.tag.domain.entity.Tag
import com.studyolle.zone.domain.command.ZoneCommand
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TagService(
    private val tagStore: TagStore,
    private val tagReader: TagReader
) {
    fun registerTag(tagCommand: TagCommand.RegisterForm) {
        /* tag 조회 */
        var tag: Tag? = tagReader.findByTitle(tagCommand.title)

        if (tag == null) {
            tag = tagCommand.toEntity()

            /* 신규 등록 */
            tagStore.registerTag(tag)
        }
    }

    fun deleteTag(title: String) {
        /* tag 조회 */
        var tag: Tag = tagReader.findByTitle(title) ?: throw BadRequestException(ErrorMessage.NOT_EXIST_INFO)

        tagStore.delete(tag)
    }

    fun getTagList(): MutableList<TagCommand> {
        return tagReader.findAll()
            .stream()
            .map { tag ->
                TagCommand(
                    title = tag.title,
                )
            }
            .collect(Collectors.toList())
    }

    fun findByTitle(title: String): TagCommand {
        /* tag 조회 */
        var tag: Tag = tagReader.findByTitle(title) ?: throw BadRequestException(ErrorMessage.NOT_EXIST_INFO)

        return TagCommand(title = tag.title)
    }

}