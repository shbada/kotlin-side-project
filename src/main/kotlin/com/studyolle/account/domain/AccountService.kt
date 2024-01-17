package com.studyolle.account.domain

import com.studyolle.account.domain.command.AccountCommand
import com.studyolle.account.domain.entity.Account
import com.studyolle.account.interfaces.dto.AccountDto
import com.studyolle.common.exception.BadRequestException
import com.studyolle.common.exception.ErrorMessage
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(
    private val accountStore: AccountStore,
    private val accountReader: AccountReader,
    private val passwordEncoder: PasswordEncoder,
    private val emailService: MailService
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    /**
     * 회원가입
     */
    fun processNewAccount(signUpForm: AccountCommand.SignUpForm) {
        /* 신규 회원 저장 */
        val newAccount = saveNewAccount(signUpForm)

        /* 이메일 토큰 발송 */
        sendSignUpConfirmEmail(newAccount)
    }

    /**
     * 이메일 토큰 발송
     * 실제로 발송은 하지 않고 DB 상태 업데이트만 한다.
     */
    private fun sendSignUpConfirmEmail(account: Account) {
        var message = "이메일 토큰 발송입니다."
        message += "userID : " + account.id
        message += "token : " + account.emailCheckToken

        /* send */
        emailService.sendEmail(message)
    }

    private fun saveNewAccount(signUpForm: AccountCommand.SignUpForm): Account {
        /* setting password */
        signUpForm.password = passwordEncoder.encode(signUpForm.password)

        /* account form to entity */
        val account: Account = signUpForm.toEntity()

        /* create email token */
        account.generateEmailCheckToken()

        /* save new account */
        accountStore.saveNewAccount(account)

        return account
    }

    @Transactional
    fun checkEmailToken(email: String, token: String) {
        val account: Account = accountReader.findByEmail(email)

        /* 계정의 이메일 인증 처리 */
        when (token != account.emailCheckToken) { // when절 써보기
            true -> account.completeSignUp()
            false -> throw BadRequestException(ErrorMessage.INVALID_EMAIL_TOKEN)
        }

//        account.completeSignUp()
    }

    fun reSendSignUpConfirmEmail(email: String) {
        val account: Account = accountReader.findByEmail(email)

        /* 시간 체크 */
        if (!account.canSendConfirmEmail()) {
            throw BadRequestException(ErrorMessage.EMAIL_ONCE_PER_HOUR)
        }

        /* 이메일 토큰 발송 */
        sendSignUpConfirmEmail(account)
    }

    fun getAccountInfo(nickname: String, email: String) {
        /* 닉네임의 회원 조회 */
        val accountToView: Account = accountReader.findByNickname(nickname)

        /* 자기 자신 여부 */
        if (accountToView.email != email) {
            throw BadRequestException(ErrorMessage.NOT_EXIST_INFO)
        }
    }

    fun updatePassword(passwordForm: AccountDto.PasswordForm) {
        val account: Account = accountReader.findByEmail(passwordForm.email)

        /* 비밀번호 업데이트 수행 */
        account.updatePassword(passwordForm.password)
    }
}