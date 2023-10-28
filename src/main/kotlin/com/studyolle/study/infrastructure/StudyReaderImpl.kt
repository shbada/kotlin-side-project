package com.studyolle.study.infrastructure

import com.studyolle.study.domain.StudyReader
import org.springframework.stereotype.Component

@Component
class StudyReaderImpl(
    private val studyRepository: StudyRepository
) : StudyReader {

}