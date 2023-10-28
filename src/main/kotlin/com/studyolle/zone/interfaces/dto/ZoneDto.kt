package com.studyolle.zone.interfaces.dto

class ZoneDto {
    data class RegisterForm(
        var city: String,
        var localNameOfCity: String,
        var province: String,
    )
}