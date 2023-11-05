package com.studyolle.zone.domain

import com.studyolle.zone.domain.entity.Zone

interface ZoneReader {
    fun count(): Long
    fun findByCity(city: String): Zone?
    fun findAll(): MutableList<Zone>
}