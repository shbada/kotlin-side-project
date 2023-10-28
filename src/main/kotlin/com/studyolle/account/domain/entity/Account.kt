package com.studyolle.account.domain.entity

import com.studyolle.common.entity.BaseEntity
import com.studyolle.tag.domain.entity.Tag
import com.studyolle.zone.domain.entity.Zone
import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "account")
@Entity
class Account (
    @Id @GeneratedValue
    private var id: Long? = null,

    @Column(unique = true) /* 중복 불가능 */
    private val email: String? = null,

    @Column(unique = true)
    private var nickname: String? = null,

    private val password: String? = null,

    /* 이메일 검증 */
    private val emailVerified: Boolean = false,

    private val emailCheckToken: String? = null,

    private val emailCheckTokenGeneratedAt: LocalDateTime? = null,

    private val joinedAt: LocalDateTime? = null, // 가입일자


    private val bio: String? = null, // 자기소개


    private val url: String? = null,

    private val occupation: String? = null, // 직업

    private val location: String? = null, // 지역 varchar(255) 기본 매핑

    @Lob
    /* CLOB */
    @Basic(fetch = FetchType.EAGER)
    /* 즉시로딩 */
    private val profileImage: String? = null, // 프로필 이미지


    private val studyCreatedByEmail: Boolean = false, // 스터디 생성 여부를 이메일로 받을것인가?


    private val studyCreatedByWeb: Boolean = false, // 스터디 생성 여부를 웹으로 받을것인가?


    private val studyEnrollmentResultByEmail: Boolean = false, // 스터디 모임 가입신청 결과를 이메일로 받을것인가?


    private val studyEnrollmentResultByWeb: Boolean = false, // 스터디 모임 가입신청 결과를 웹으로 받을것인가?


    private val studyUpdatedByEmail: Boolean = false, // 스터디 변경 정보를 이메일로 받을것인가?


    private val studyUpdatedByWeb: Boolean = false, // 스터디 변경 정보를 웹으로 받을것인가?


    /* account_tags 테이블 생성 */
    @ManyToMany
    private val tags: Set<Tag> = HashSet<Tag>(),

    /* account_zones 테이블 생성 */
    @ManyToMany
    private val zones: Set<Zone> = HashSet<Zone>()
) : BaseEntity() {

}