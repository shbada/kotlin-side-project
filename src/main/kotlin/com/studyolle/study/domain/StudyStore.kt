package com.studyolle.study.domain

import com.studyolle.study.domain.entity.Study
import java.util.*

interface StudyStore {
    fun createNewStudy(study: Study)
    fun getStudy(studyIdx: Long): Optional<Study>
}