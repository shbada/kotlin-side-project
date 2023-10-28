package com.studyolle.study.interfaces.mapper

import com.studyolle.study.domain.command.StudyCommand
import com.studyolle.study.interfaces.dto.StudyDto

class StudyDtoMapper {
    companion object {
        fun of(registerForm: StudyDto.RegisterForm): StudyCommand.RegisterForm =
            StudyCommand.RegisterForm(
                email = registerForm.email,
                path = registerForm.path,
                title = registerForm.title,
                shortDescription = registerForm.shortDescription,
                fullDescription = registerForm.fullDescription,
            )
    }
}