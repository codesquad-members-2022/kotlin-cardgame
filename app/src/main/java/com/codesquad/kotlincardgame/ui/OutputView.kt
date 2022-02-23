package com.codesquad.kotlincardgame.ui

import com.codesquad.kotlincardgame.card.Card
import java.lang.System.lineSeparator

object OutputView {

    private const val INIT_MESSAGE = "카드 전체를 초기화했습니다."
    private const val COUNT_MESSAGE = "총 %d개의 카드가 있습니다.\n"
    private const val MIX_MESSAGE = "전체 %d장의 카드를 섞었습니다.\n"
    private const val REST_MESSAGE = "총 %d개의 카드가 남았습니다.\n"
    private const val MENU_MESSAGE = "카드 초기화 / 카드 섞기 / 카드 하나 뽑기"

    fun printInit() {
        println(MENU_MESSAGE)
        lineSeparator()
    }

    fun printReset(count: Int) {
        println(INIT_MESSAGE)
        println(String.format(COUNT_MESSAGE, count))
    }

    fun printShuffle(count: Int) {
        println(String.format(MIX_MESSAGE, count))
    }

    fun printRemain(card: Card, count: Int) {
        println(card)
        lineSeparator()
        println(String.format(REST_MESSAGE, count))
    }

}