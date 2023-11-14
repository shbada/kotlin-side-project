package com.studyolle.study.interfaces.dto

class StudyDto(
    var path: String,
    val title: String,
    val shortDescription: String?,
    val fullDescription: String?,
) {
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