package com.studyolle.zone.infrastructure

import com.studyolle.zone.domain.ZoneReader
import com.studyolle.zone.domain.entity.Zone
import org.springframework.stereotype.Component

@Component
class ZoneReaderImpl(
    private val zoneRepository: ZoneRepository
) : ZoneReader {
    override fun count(): Long {
        return zoneRepository.count()
    }

    override fun findByCity(city: String): Zone? {
        return zoneRepository.findByCity(city)
    }

    override fun findAll(): MutableList<Zone> {
        return zoneRepository.findAll()
    }
}