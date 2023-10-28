package com.studyolle.tag.infrastructure

import com.studyolle.tag.domain.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository: JpaRepository<Tag, Long> {
    fun findByTitle(title: String): Tag?
}