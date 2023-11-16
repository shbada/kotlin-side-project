package com.studyolle.study.interfaces.mapper

import com.studyolle.study.domain.command.StudyCommand
import com.studyolle.study.interfaces.dto.StudyDto
import com.studyolle.tag.domain.command.TagCommand
import com.studyolle.tag.interfaces.dto.TagDto

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

        fun of(studyCommand: StudyCommand): StudyDto =
            StudyDto(
                path = studyCommand.path,
                title = studyCommand.title,
                shortDescription = studyCommand.shortDescription,
                fullDescription = studyCommand.fullDescription,
            )
    }
}