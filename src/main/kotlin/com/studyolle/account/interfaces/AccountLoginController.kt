package com.studyolle.account.interfaces

import com.studyolle.account.application.AccountFacade
import com.studyolle.account.application.AccountLoginFacade
import com.studyolle.account.interfaces.dto.AccountDto
import com.studyolle.account.interfaces.dto.AccountLoginDto
import com.studyolle.account.interfaces.mapper.AccountDtoMapper
import com.studyolle.common.response.CommonResponse
import com.studyolle.common.response.ResponseDto
import com.studyolle.study.interfaces.dto.StudyDto
import com.studyolle.study.interfaces.mapper.StudyDtoMapper
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*
import java.util.stream.Collectors

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/account-login")
class AccountLoginController(
    private val accountLoginFacade: AccountLoginFacade
) {
    @GetMapping()
    fun getAccountLoginNameList(
    ): ResponseEntity<ResponseDto<List<AccountLoginDto>>> {
        val resultList = accountLoginFacade.findAll()

        // TODO
        return CommonResponse.send(Collections.emptyList())
    }
}