package com.codesquad.kotlincardgame.card

import java.lang.IllegalArgumentException

enum class GameMode(val gameMode: Int) {
    TWO(2),
    THREE(3),
    FOUR(4);

    companion object {
        private const val NOT_FOUND_GAMEMODE_MESSAGE = "존재하지 않는 게임모드입니다."

        fun values(gameMode: String) = GameMode.values().asSequence()
            .find { it.gameMode == gameMode.toInt() }
            ?: throw IllegalArgumentException(NOT_FOUND_GAMEMODE_MESSAGE)
    }
}