package com.studyolle.tag.interfaces

import com.studyolle.common.response.CommonResponse
import com.studyolle.common.response.ResponseDto
import com.studyolle.tag.application.TagFacade
import com.studyolle.tag.interfaces.dto.TagDto
import com.studyolle.tag.interfaces.mapper.TagDtoMapper
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/tag")
class TagController(
    private val tagFacade: TagFacade
) {
    /**
     * 태그 등록
     */
    @PostMapping
    fun registerTag(
        @RequestBody registerForm: TagDto.RegisterForm
    ): ResponseEntity<ResponseDto<Void>> {
        tagFacade.registerTag(TagDtoMapper.of(registerForm))
        return CommonResponse.send()
    }

    /**
     * 태그 삭제
     */
    @DeleteMapping
    fun deleteTag(
        @RequestBody title: String
    ): ResponseEntity<ResponseDto<Void>> {
        tagFacade.deleteTag(title)
        return CommonResponse.send()
    }
}