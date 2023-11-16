package com.studyolle.zone.interfaces.mapper

import com.studyolle.zone.domain.command.ZoneCommand
import com.studyolle.zone.interfaces.dto.ZoneDto

class ZoneDtoMapper {
    companion object {
        fun of(registerForm: ZoneDto.RegisterForm): ZoneCommand.RegisterForm =
            ZoneCommand.RegisterForm(
                city = registerForm.city,
                localNameOfCity = registerForm.localNameOfCity,
                province = registerForm.province,
            )

        fun of(zoneCommand: ZoneCommand): ZoneDto =
            ZoneDto(
                city = zoneCommand.city,
                localNameOfCity = zoneCommand.localNameOfCity,
                province = zoneCommand.province
            )
    }
}