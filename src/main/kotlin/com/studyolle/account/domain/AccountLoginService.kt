package com.studyolle.account.domain

import com.studyolle.account.domain.command.AccountLoginCommand
import com.studyolle.account.domain.entity.AccountLogin
import com.studyolle.common.exception.BadRequestException
import com.studyolle.common.exception.ErrorMessage
import com.studyolle.study.domain.command.StudyCommand
import com.studyolle.study.domain.entity.Study
import com.studyolle.zone.domain.command.ZoneCommand
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class AccountLoginService(
    private val accountLoginReader: AccountLoginReader,
    private val accountLoginStore: AccountLoginStore
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun findAll(): MutableList<AccountLoginCommand> {
        return accountLoginReader.findAll()
            .stream()
            .map { accountLogin ->
                AccountLoginCommand(
                    nickname = accountLogin.nickname
                )
            }
            .collect(Collectors.toList())
    }

    fun registerAccountLogin(registerForm: AccountLoginCommand.RegisterForm) {
        val accountLogin: AccountLogin = registerForm.toEntity()
        accountLoginStore.registerAccountLogin(accountLogin)
    }

    fun findById(accountLoginIdx: Long): AccountLoginCommand {
        val accountLogin: Optional<AccountLogin> = accountLoginReader.findById(accountLoginIdx)

        when (!accountLogin.isPresent) {
            true -> return AccountLoginCommand(accountLogin.get().nickname)
            false -> throw BadRequestException(ErrorMessage.NOT_EXIST_INFO)
        }
    }


}