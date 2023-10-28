package com.studyolle.zone.domain.command

import com.studyolle.zone.domain.entity.Zone

class ZoneCommand {
    data class RegisterForm(
        val city: String,
        val localNameOfCity: String,
        val province: String,
    ) {
        fun toEntity() = Zone (
            city = city,
            localNameOfCity = localNameOfCity,
            province = province,
        )
    }
}