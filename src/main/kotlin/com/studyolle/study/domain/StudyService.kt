package com.studyolle.study.domain

import com.studyolle.common.exception.BadRequestException
import com.studyolle.common.exception.ErrorMessage
import com.studyolle.study.domain.command.StudyCommand
import com.studyolle.study.domain.entity.Study
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudyService(
    private val studyStore: StudyStore
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun createNewStudy(registerForm: StudyCommand.RegisterForm) {
        /* TODO email 체크 (account API call) */

        val study: Study = registerForm.toEntity()

        /* 스터디 저장 */
        studyStore.createNewStudy(study)
    }

    fun getStudy(studyIdx: Long): Study {
        val study: Optional<Study> = studyStore.getStudy(studyIdx)

        if (!study.isPresent) {
            throw BadRequestException(ErrorMessage.NOT_EXIST_INFO)
        }

        return study.get()
    }
}