package com.studyolle.account.interfaces

import com.studyolle.account.application.AccountFacade
import com.studyolle.account.interfaces.dto.AccountDto
import com.studyolle.account.interfaces.mapper.AccountDtoMapper
import com.studyolle.common.response.CommonResponse
import com.studyolle.common.response.ResponseDto
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/account")
class AccountController(
    private val accountFacade: AccountFacade,
) {
    /**
     * 회원가입
     */
    @PostMapping
    fun signUpSubmit(
        @RequestBody signUpForm: AccountDto.SignUpForm
    ): ResponseEntity<ResponseDto<Void>> {
        accountFacade.processNewAccount(AccountDtoMapper.of(signUpForm))
        return CommonResponse.send()
    }

    /**
     * 이메일 토큰 유효성 체크
     */
    @GetMapping("/check-email-token")
    fun checkEmailToken(
        token: String, email: String
    ): ResponseEntity<ResponseDto<Void>> {
        accountFacade.checkEmailToken(email, token)
        return CommonResponse.send()
    }

    /**
     * 이메일 토큰 재발송
     */
    @GetMapping("/resend-confirm-email")
    fun resendConfirmEmail(
        email: String
    ): ResponseEntity<ResponseDto<Void>> {
        /* 이메일 인증 발송 */
        accountFacade.reSendSignUpConfirmEmail(email)
        return CommonResponse.send()
    }

    /**
     * 유저의 프로필 정보 조회
     */
    @GetMapping("/profile/{nickname}")
    fun viewProfile(
        @PathVariable nickname: String,
        email: String
    ): ResponseEntity<ResponseDto<Void>> {
        accountFacade.getAccountInfo(nickname, email)
        return CommonResponse.send()
    }

    /**
     * 패스워드 변경
     */
    @PutMapping("/password")
    fun updatePassword(@RequestBody passwordForm: AccountDto.PasswordForm): ResponseEntity<ResponseDto<Void>> {
        accountFacade.updatePassword(passwordForm)
        return CommonResponse.send()
    }
}