package com.studyolle.study.infrastructure

import com.studyolle.study.domain.StudyReader
import com.studyolle.study.domain.entity.Study
import org.springframework.stereotype.Component
import java.util.*

@Component
class StudyReaderImpl(
    private val studyRepository: StudyRepository
) : StudyReader {
    override fun findAll(): MutableList<Study> {
        return studyRepository.findAll()
    }

    override fun findById(studyIdx: Long): Optional<Study> {
        return studyRepository.findById(studyIdx)
    }
}