package com.studyolle.study.infrastructure

import com.studyolle.study.domain.entity.Study
import org.springframework.data.jpa.repository.JpaRepository

interface StudyRepository: JpaRepository<Study, Long> {
    fun findStudyWithMembersByPath(path: String): Study
}