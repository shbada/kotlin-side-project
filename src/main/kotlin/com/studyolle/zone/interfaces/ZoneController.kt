package com.studyolle.zone.interfaces

import com.studyolle.common.response.CommonResponse
import com.studyolle.common.response.ResponseDto
import com.studyolle.tag.interfaces.dto.TagDto
import com.studyolle.zone.application.ZoneFacade
import com.studyolle.zone.domain.command.ZoneCommand
import com.studyolle.zone.interfaces.dto.ZoneDto
import com.studyolle.zone.interfaces.mapper.ZoneDtoMapper
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/zone")
class ZoneController(
    private val zoneFacade: ZoneFacade
) {
    /**
     * zone 초기화
     */
    @PostMapping("/init")
    fun initZone(
    ) {
        zoneFacade.initZone()
    }

    /**
     * zone 등록
     */
    @PostMapping
    fun registerZone(
        @RequestBody registerForm: ZoneDto.RegisterForm
    ): ResponseEntity<ResponseDto<Void>> {
        zoneFacade.registerZone(ZoneDtoMapper.of(registerForm))
        return CommonResponse.send()
    }

    /**
     * zone 삭제
     */
    @DeleteMapping
    fun deleteZone(
        @RequestBody city: String
    ): ResponseEntity<ResponseDto<Void>> {
        zoneFacade.deleteZone(city)
        return CommonResponse.send()
    }

    /**
     * Zone 리스트 조회
     */
    @GetMapping("/list")
    fun getZoneList(
    ): ResponseEntity<ResponseDto<List<ZoneDto>>> {
        val zoneList = zoneFacade.findAll()

        val zoneDtoList = zoneList
            .stream()
            .map(ZoneDtoMapper.Companion::of)
            .collect(Collectors.toList())

        return CommonResponse.send(zoneDtoList)
    }

    /**
     * zone 정보 조회
     */
    @GetMapping()
    fun getZone(
        @RequestParam city: String
    ): ResponseEntity<ResponseDto<ZoneDto>> {
        val zoneCommand = zoneFacade.findByCity(city)
        return CommonResponse.send(ZoneDto(zoneCommand.city, zoneCommand.localNameOfCity, zoneCommand.province))
    }
}