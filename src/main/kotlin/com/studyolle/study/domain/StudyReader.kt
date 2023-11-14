package com.studyolle.study.domain

import com.studyolle.study.domain.entity.Study
import com.studyolle.tag.domain.entity.Tag

interface StudyReader {
    fun findAll(): MutableList<Study>
}