package com.studyolle.zone.infrastructure

import com.studyolle.zone.domain.ZoneStore
import com.studyolle.zone.domain.entity.Zone
import org.springframework.stereotype.Component

@Component
class ZoneStoreImpl(
    private val zoneRepository: ZoneRepository
) : ZoneStore {
    override fun save(zone: Zone) {
        zoneRepository.save(zone);
    }

    override fun saveAll(zoneList: List<Zone>) {
        zoneRepository.saveAll(zoneList)
    }
}