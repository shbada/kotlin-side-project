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
    private var id: Long? = null,

    /* study_managers 테이블 생성 */
    @ManyToMany
    private val managers: Set<Account> = HashSet<Account>(),

    /* study_members 테이블 생성 */
    @ManyToMany
    private val members: Set<Account> = HashSet<Account>(),

    @Column(unique = true)
    private var path: String? = null,

    private val title: String? = null,

    private val shortDescription: String? = null,

    @Lob
    @Basic(fetch = FetchType.EAGER)
    private val fullDescription: String? = null,

    @Lob
    @Basic(fetch = FetchType.EAGER)
    private val image: String? = null,

    /* study_tags 테이블 생성 */
    @ManyToMany
    private val tags: Set<Tag> = HashSet<Tag>(),

    /* study_zones 테이블 생성 */
    @ManyToMany
    private val zones: Set<Zone> = HashSet<Zone>(),

    private val publishedDateTime: LocalDateTime? = null,

    private val closedDateTime: LocalDateTime? = null,

    private val recruitingUpdatedDateTime: LocalDateTime? = null,

    private val recruiting: Boolean = false,

    private val published: Boolean = false,

    private val closed: Boolean = false,

    private val useBanner: Boolean = false,

    private val memberCount: Long = 0
) : BaseEntity() {

}