package com.studyolle.zone.infrastructure

import com.studyolle.zone.domain.entity.Zone
import org.springframework.data.jpa.repository.JpaRepository

interface ZoneRepository: JpaRepository<Zone, Long> {
    fun findByCity(city: String): Zone?
}