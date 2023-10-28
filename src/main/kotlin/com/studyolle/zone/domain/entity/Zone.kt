package com.studyolle.zone.domain.entity

import com.studyolle.common.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "zone")
@Entity
class Zone (
    @Id
    @GeneratedValue
    private val id: Long? = null,
    private var city: String? = null,
    private var localNameOfCity: String? = null,
    private var province: String? = null
) : BaseEntity() {
    constructor(city: String, localNameOfCity: String, province: String): this() {
        this.city = city
        this.localNameOfCity = localNameOfCity
        this.province = province
    }
}
