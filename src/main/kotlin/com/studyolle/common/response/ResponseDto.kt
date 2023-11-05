package com.studyolle.common.response

class ResponseDto<T> {
    var code: String = "00"
    var message: String = "성공"
    var data: T? = null
}