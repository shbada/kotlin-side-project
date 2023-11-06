package com.studyolle.tag.infrastructure

import com.studyolle.tag.domain.TagReader
import com.studyolle.tag.domain.entity.Tag
import org.apache.commons.lang3.mutable.Mutable
import org.springframework.stereotype.Component

@Component
class TagReaderImpl(
    private val tagRepository: TagRepository
) : TagReader {
    override fun findByTitle(title: String): Tag? {
        return tagRepository.findByTitle(title)
    }

    override fun findAll(): MutableList<Tag> {
        return tagRepository.findAll()
    }
}