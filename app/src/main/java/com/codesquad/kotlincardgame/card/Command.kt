package com.codesquad.kotlincardgame.card

import java.lang.IllegalArgumentException

enum class Command(private val command: String) {
    RESET("카드 초기화"),
    SHUFFLE("카드 섞기"),
    REMOVE("카드 하나 뽑기"),
    EXIT("종료");

    companion object {
        private const val NOT_FOUND_COMMAND_MESSAGE = "명령어를 찾을 수 있습니다."

        fun values(command: String) = values().asSequence()
            .find { it.command == command }
            ?: throw IllegalArgumentException(NOT_FOUND_COMMAND_MESSAGE)
    }
}