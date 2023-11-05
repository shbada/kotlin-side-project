package com.studyolle.zone.interfaces.dto

class ZoneDto(
    var city: String?,
    var localNameOfCity: String?,
    var province: String?,
) {
    data class RegisterForm(
        var city: String,
        var localNameOfCity: String,
        var province: String,
    )
}