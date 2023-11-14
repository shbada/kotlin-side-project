package com.studyolle.study.domain.entity

import com.studyolle.account.domain.entity.Account
import com.studyolle.common.entity.BaseEntity
import com.studyolle.tag.domain.entity.Tag
import com.studyolle.zone.domain.entity.Zone
import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "study")
@Entity
class Study (
    @Id @GeneratedValue
    var id: Long? = null,

    /* study_managers 테이블 생성 */
    @ManyToMany
    val managers: Set<Account> = HashSet<Account>(),

    /* study_members 테이블 생성 */
    @ManyToMany
    val members: Set<Account> = HashSet<Account>(),

    @Column(unique = true)
    var path: String,

    val title: String,

    val shortDescription: String? = null,

    @Lob
    @Basic(fetch = FetchType.EAGER)
    val fullDescription: String? = null,

    @Lob
    @Basic(fetch = FetchType.EAGER)
    val image: String? = null,

    /* study_tags 테이블 생성 */
    @ManyToMany
    val tags: Set<Tag> = HashSet<Tag>(),

    /* study_zones 테이블 생성 */
    @ManyToMany
    val zones: Set<Zone> = HashSet<Zone>(),

    val publishedDateTime: LocalDateTime? = null,

    val closedDateTime: LocalDateTime? = null,

    val recruitingUpdatedDateTime: LocalDateTime? = null,

    val recruiting: Boolean = false,

    val published: Boolean = false,

    val closed: Boolean = false,

    val useBanner: Boolean = false,

    val memberCount: Long = 0
) : BaseEntity() {

}