package com.studyolle.tag.domain.entity

import com.studyolle.common.entity.BaseEntity
import jakarta.persistence.*

@Table(name = "tag")
@Entity
class Tag (
    @Id
    @GeneratedValue
    private val id: Long? = null,

    @Column(unique = true)
    private val title: String? = null
) : BaseEntity() {

}
