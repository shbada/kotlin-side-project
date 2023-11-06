package com.studyolle.tag.domain.command

import com.studyolle.tag.domain.entity.Tag

class TagCommand(
    val title: String,
) {
    data class RegisterForm(
        val title: String,
    ) {
        fun toEntity() = Tag (
            title = title,
        )
    }
}