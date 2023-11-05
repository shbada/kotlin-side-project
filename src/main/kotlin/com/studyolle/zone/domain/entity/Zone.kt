package com.studyolle.zone.domain.entity

import com.studyolle.common.entity.BaseEntity
import com.studyolle.zone.domain.command.ZoneCommand
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "zone")
@Entity
class Zone (
    @Id
    @GeneratedValue
    val id: Long? = null,
    var city: String? = null,
    var localNameOfCity: String? = null,
    var province: String? = null
) : BaseEntity() {
    constructor(city: String, localNameOfCity: String, province: String): this() {
        this.city = city
        this.localNameOfCity = localNameOfCity
        this.province = province
    }
}
