package com.studyolle.zone.application

import com.studyolle.zone.domain.ZoneService
import com.studyolle.zone.domain.command.ZoneCommand
import com.studyolle.zone.domain.entity.Zone
import org.springframework.stereotype.Service

@Service
class ZoneFacade(
    private val zoneService: ZoneService
) {
    fun initZone() {
        zoneService.initZone()
    }

    fun registerZone(zoneCommand: ZoneCommand.RegisterForm) {
        zoneService.registerZone(zoneCommand)
    }

    fun deleteZone(city: String) {
        zoneService.deleteZone(city)
    }

    fun getZoneList(): MutableList<ZoneCommand> {
        return zoneService.getZoneList()
    }
}