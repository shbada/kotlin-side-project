package com.studyolle.tag.interfaces.mapper

import com.studyolle.tag.domain.command.TagCommand
import com.studyolle.tag.interfaces.dto.TagDto

class TagDtoMapper {
    companion object {
        fun of(registerForm: TagDto.RegisterForm): TagCommand.RegisterForm =
            TagCommand.RegisterForm(
                title = registerForm.title,
            )
    }
}