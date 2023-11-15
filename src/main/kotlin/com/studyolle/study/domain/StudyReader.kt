package com.studyolle.study.domain

import com.studyolle.study.domain.entity.Study
import com.studyolle.tag.domain.entity.Tag
import java.util.*

interface StudyReader {
    fun findAll(): MutableList<Study>
    fun findById(studyIdx: Long): Optional<Study>
}