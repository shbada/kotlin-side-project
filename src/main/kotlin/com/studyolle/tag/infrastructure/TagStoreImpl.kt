package com.studyolle.tag.infrastructure

import com.studyolle.tag.domain.TagStore
import com.studyolle.tag.domain.entity.Tag
import org.springframework.stereotype.Component

@Component
class TagStoreImpl(
    private val tagRepository: TagRepository
) : TagStore {
    override fun registerTag(tag: Tag) {
        tagRepository.save(tag)
    }
}