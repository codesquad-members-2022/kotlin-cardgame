package com.codesquad.kotlincardgame.player

import java.util.*

data class Name(val name: String) {
    init {
        require(name.isNotBlank()) { BLANK_MESSAGE }
        require(name.length in MINIMUM..MAXIMUM) { OUT_OF_RANGE_MESSAGE }
    }

    companion object {
        private val names = mutableListOf("ivy", "jk", "crong", "honux", "nam")
        private const val BLANK_MESSAGE = "이름은 비어있서는 안 됩니다."
        private const val OUT_OF_RANGE_MESSAGE = "이름의 길이는 5를 초과한 %s가 입력되었습니다."
        private const val MAXIMUM = 5
        private const val MINIMUM = 2

        fun getRandomName(): String {
            val idx = Random().nextInt(names.size)
            return names.removeAt(idx)
        }
    }
}