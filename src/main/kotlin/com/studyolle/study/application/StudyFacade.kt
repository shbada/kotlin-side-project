package com.studyolle.study.application

import com.studyolle.study.domain.StudyService
import com.studyolle.study.domain.command.StudyCommand
import org.springframework.stereotype.Service

@Service
class StudyFacade(
    private val studyService: StudyService,
) {
    fun createNewStudy(registerForm: StudyCommand.RegisterForm) {
        studyService.createNewStudy(registerForm)
    }

    fun getStudy(studyIdx: Long) {
        studyService.getStudy(studyIdx)
    }
}