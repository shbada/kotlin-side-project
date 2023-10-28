package com.studyolle.tag.domain

import com.studyolle.tag.domain.entity.Tag

interface TagStore {
    fun registerTag(tag: Tag)
}