package com.studyolle.study.interfaces.dto

class StudyDto {
    data class RegisterForm(
        var email: String,
        var path: String,
        val title: String,
        val shortDescription: String,
        val fullDescription: String,
    )

    data class LeaveForm(
        var email: String,
        var path: String,
    )
}