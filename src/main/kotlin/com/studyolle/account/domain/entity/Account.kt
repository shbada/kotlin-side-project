package com.studyolle.account.domain.entity

import com.studyolle.common.entity.BaseEntity
import com.studyolle.tag.domain.entity.Tag
import com.studyolle.zone.domain.entity.Zone
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Table(name = "account")
@Entity
class Account (
        @Id @GeneratedValue
    val id: Long? = null,

        @Column(unique = true) /* 중복 불가능 */
    val email: String? = null,

        @Column(unique = true)
    var nickname: String? = null,

        var password: String? = null,

        /* 이메일 검증 */
    var emailVerified: Boolean = false,

        var emailCheckToken: String? = null,

        var emailCheckTokenGeneratedAt: LocalDateTime? = null,

        var joinedAt: LocalDateTime? = null, // 가입일자

        val bio: String? = null, // 자기소개

        val url: String? = null,

        val occupation: String? = null, // 직업

        val location: String? = null, // 지역 varchar(255) 기본 매핑

        @Lob /* CLOB */
    @Basic(fetch = FetchType.EAGER) /* 즉시로딩 */
    val profileImage: String? = null, // 프로필 이미지

        val studyCreatedByEmail: Boolean = false, // 스터디 생성 여부를 이메일로 받을것인가?

        val studyCreatedByWeb: Boolean = false, // 스터디 생성 여부를 웹으로 받을것인가?

        val studyEnrollmentResultByEmail: Boolean = false, // 스터디 모임 가입신청 결과를 이메일로 받을것인가?

        val studyEnrollmentResultByWeb: Boolean = false, // 스터디 모임 가입신청 결과를 웹으로 받을것인가?

        val studyUpdatedByEmail: Boolean = false, // 스터디 변경 정보를 이메일로 받을것인가?

        val studyUpdatedByWeb: Boolean = false, // 스터디 변경 정보를 웹으로 받을것인가?

        /* account_tags 테이블 생성 */
    @ManyToMany
    val tags: Set<Tag> = HashSet<Tag>(),

        /* account_zones 테이블 생성 */
    @ManyToMany
    val zones: Set<Zone> = HashSet<Zone>()
) : BaseEntity() {
    fun generateEmailCheckToken() {
        emailCheckToken = UUID.randomUUID().toString()
        emailCheckTokenGeneratedAt = LocalDateTime.now()
    }

    fun completeSignUp() {
        emailVerified = true
        joinedAt = LocalDateTime.now()
    }

    fun canSendConfirmEmail(): Boolean {
        return emailCheckTokenGeneratedAt!!.isBefore(LocalDateTime.now().minusHours(1))
    }

    fun updatePassword(password: String) {
        this.password = password
    }
}