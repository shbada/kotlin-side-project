package com.studyolle.common.exception

enum class ErrorMessage (
    val code: String,
    val message: String
) {
    NOT_EXIST_INFO("4001", "해당 정보는 존재하지 않습니다."),
    INVALID_EMAIL_TOKEN("4002", "유효하지 않은 토큰입니다."),
    EMAIL_ONCE_PER_HOUR("4003", "인증 이메일은 1시간에 한번만 전송할 수 있습니다."),
}