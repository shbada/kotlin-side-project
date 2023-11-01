package com.studyolle.account.interfaces

import com.studyolle.account.application.AccountFacade
import com.studyolle.account.interfaces.dto.AccountDto
import com.studyolle.account.interfaces.mapper.AccountDtoMapper
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

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
    ) {
        accountFacade.processNewAccount(AccountDtoMapper.of(signUpForm))
    }

    /**
     * 이메일 토큰 유효성 체크
     */
    @GetMapping("/check-email-token")
    fun checkEmailToken(token: String, email: String) {
        accountFacade.checkEmailToken(email, token)
    }
}