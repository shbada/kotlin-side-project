package com.studyolle.zone.domain

import com.studyolle.zone.domain.entity.Zone

interface ZoneStore {
    fun save(zone: Zone)
    fun saveAll(zoneList: List<Zone>)
    fun delete(zone: Zone)
}