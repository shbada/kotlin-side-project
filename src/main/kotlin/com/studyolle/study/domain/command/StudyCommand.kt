package com.studyolle.study.domain.command

import com.studyolle.study.domain.entity.Study

class StudyCommand {
    data class RegisterForm(
        val email: String,
        val path: String,
        val title: String,
        var shortDescription: String,
        var fullDescription: String,
    ) {
        fun toEntity() = Study(
            path = path,
            title = title,
            shortDescription = shortDescription,
            fullDescription = fullDescription,
        )
    }
}