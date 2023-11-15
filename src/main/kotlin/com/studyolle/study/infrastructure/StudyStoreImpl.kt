package com.studyolle.study.infrastructure

import com.studyolle.study.domain.entity.Study
import com.studyolle.study.domain.StudyStore
import org.springframework.stereotype.Component
import java.util.*

@Component
class StudyStoreImpl(
    private val studyRepository: StudyRepository
) : StudyStore {
    override fun createNewStudy(study: Study) {
        studyRepository.save(study)
    }
}