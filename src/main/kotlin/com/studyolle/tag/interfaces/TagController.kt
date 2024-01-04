package com.studyolle.tag.interfaces

import com.studyolle.common.response.CommonResponse
import com.studyolle.common.response.ResponseDto
import com.studyolle.tag.application.TagFacade
import com.studyolle.tag.interfaces.dto.TagDto
import com.studyolle.tag.interfaces.mapper.TagDtoMapper
import com.studyolle.zone.interfaces.dto.ZoneDto
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

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

    /**
     * 태그 리스트 조회
     */
    @GetMapping("/list")
    fun getTagList(
    ): ResponseEntity<ResponseDto<List<TagDto>>> {
        val tagList = tagFacade.findAll()

        val tagDtoList = tagList
            .stream()
            .map(TagDtoMapper.Companion::of)
            .collect(Collectors.toList())

        return CommonResponse.send(tagDtoList)
    }

    /**
     * 태그 정보 조회
     */
    @GetMapping()
    fun getTag(
        @RequestParam title: String
    ): ResponseEntity<ResponseDto<TagDto>> {
        val tagCommand = tagFacade.findByTitle(title)
        return CommonResponse.send(TagDto(title = tagCommand.title))
    }
}