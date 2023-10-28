package com.studyolle.zone.domain

import com.studyolle.tag.domain.entity.Tag
import com.studyolle.zone.domain.command.ZoneCommand
import com.studyolle.zone.domain.entity.Zone
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

@Service
class ZoneService(
    private val zoneStore: ZoneStore,
    private val zoneReader: ZoneReader
) {
    fun initZone() {
        if (zoneReader.count().toInt() == 0) {
            val resource: Resource = ClassPathResource("zones_kr.csv")
            val zoneList = Files.readAllLines(resource.file.toPath(), StandardCharsets.UTF_8).stream()
                .map { line: String ->
                    val split = line.split(",".toRegex())
                        .dropLastWhile { it.isEmpty() } // 값이 비어있지 않은 경우까지의 요소들
                        .toTypedArray()

                    Zone(city = split[0], localNameOfCity = split[1], province = split[2])
                }.collect(Collectors.toList())

            zoneStore.saveAll(zoneList)
        }
    }

    fun registerZone(zoneCommand: ZoneCommand.RegisterForm) {
        /* zone 조회 */
        var zone: Zone? = zoneReader.findByCity(zoneCommand.city)

        if (zone == null) {
            var zone : Zone = zoneCommand.toEntity()

            /* 신규 등록 */
            zoneStore.save(zone)
        }

    }
}