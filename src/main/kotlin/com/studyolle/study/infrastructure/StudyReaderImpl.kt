package com.studyolle.study.infrastructure

import com.studyolle.study.domain.StudyReader
import com.studyolle.study.domain.entity.Study
import org.springframework.stereotype.Component

@Component
class StudyReaderImpl(
    private val studyRepository: StudyRepository
) : StudyReader {
    override fun findAll(): MutableList<Study> {
        return studyRepository.findAll()
    }

}