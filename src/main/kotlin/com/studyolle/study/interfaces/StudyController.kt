package com.studyolle.study.interfaces

import com.studyolle.study.application.StudyFacade
import com.studyolle.common.response.CommonResponse
import com.studyolle.common.response.ResponseDto
import com.studyolle.study.interfaces.dto.StudyDto
import com.studyolle.study.interfaces.mapper.StudyDtoMapper
import com.studyolle.tag.interfaces.dto.TagDto
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/study")
class StudyController(
    private val studyFacade: StudyFacade,
) {
    /**
     * 스터디 등록
     */
    @PostMapping
    fun studyRegister(
        @RequestBody registerForm: StudyDto.RegisterForm
    ) {
        studyFacade.createNewStudy(StudyDtoMapper.of(registerForm))
    }

    /**
     * 스터디 단건조회
     */
    @GetMapping("/{studyIdx}")
    fun findById(
        @PathVariable studyIdx: Long
    ): ResponseEntity<*> {
        return CommonResponse.send(studyFacade.findById(studyIdx))
    }

    /**
     * 스터디 리스트 조회
     */
    @GetMapping()
    fun getStudyList(
    ): ResponseEntity<ResponseDto<List<StudyDto>>> {
        val studyList = studyFacade.findAll()

        val studyDtoList = studyList
            .stream()
            .map(StudyDtoMapper.Companion::of)
            .collect(Collectors.toList())

        return CommonResponse.send(studyDtoList)
    }
}