package com.studyolle.tag.domain

import com.studyolle.tag.domain.entity.Tag

interface TagReader {
    fun findByTitle(title: String): Tag?
}