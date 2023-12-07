package com.studyolle.study.domain

import com.studyolle.common.exception.BadRequestException
import com.studyolle.common.exception.ErrorMessage
import com.studyolle.study.domain.command.StudyCommand
import com.studyolle.study.domain.entity.Study
import com.studyolle.zone.domain.command.ZoneCommand
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class StudyService(
    private val studyStore: StudyStore,
    private val studyReader: StudyReader,
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun createNewStudy(registerForm: StudyCommand.RegisterForm) {
        /* TODO email 체크 (account API call) */

        val study: Study = registerForm.toEntity()

        /* 스터디 저장 */
        studyStore.createNewStudy(study)
    }

    fun findById(studyIdx: Long): Study {
        val study: Optional<Study> = studyReader.findById(studyIdx)

        when (!study.isPresent) { // when절 써보기
            true -> return study.get()
            false -> throw BadRequestException(ErrorMessage.NOT_EXIST_INFO)
        }
    }

    fun findAll(): MutableList<StudyCommand> {
        return studyReader.findAll()
            .stream()
            .map { study ->
                StudyCommand(
                    path = study.path,
                    title = study.title,
                    shortDescription = study.shortDescription,
                    fullDescription = study.fullDescription
                )
            }
            .collect(Collectors.toList())

    }
}