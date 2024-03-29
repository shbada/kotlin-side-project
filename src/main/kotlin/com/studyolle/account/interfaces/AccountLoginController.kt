package com.studyolle.account.interfaces

import com.studyolle.account.application.AccountLoginFacade
import com.studyolle.account.domain.command.AccountLoginCommand
import com.studyolle.account.interfaces.dto.AccountLoginDto
import com.studyolle.account.interfaces.mapper.AccountLoginDtoMapper
import com.studyolle.common.response.CommonResponse
import com.studyolle.common.response.ResponseDto
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

/**
 * with MongoDB
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/account-login")
class AccountLoginController(
    private val accountLoginFacade: AccountLoginFacade
) {
    /**
     * 로그인 히스토리 단건 등록
     */
    @PostMapping
    fun registerAccountLogin(
        @RequestBody registerForm: AccountLoginDto.RegisterForm
    ): ResponseEntity<ResponseDto<Void>> {
        accountLoginFacade.registerAccountLogin(AccountLoginDtoMapper.of(registerForm))
        return CommonResponse.send()
    }

    /**
     * 로그인 히스토리 리스트 조회
     */
    @GetMapping()
    fun getAccountLoginNameList(
    ): ResponseEntity<ResponseDto<List<AccountLoginDto>>> {
        val accountLoginList = accountLoginFacade.findAll()

        val accountLoginDtoList = accountLoginList
            .stream()
            .map(AccountLoginDtoMapper.Companion::of)
            .collect(Collectors.toList())

        return CommonResponse.send(accountLoginDtoList)
    }

    /**
     * 로그인 히스토리 단건조회
     */
    @GetMapping("/{accountLoginIdx}")
    fun findById(
        @PathVariable accountLoginIdx: Long
    ): ResponseEntity<ResponseDto<AccountLoginCommand>> {
        return CommonResponse.send(accountLoginFacade.findById(accountLoginIdx))
    }
}