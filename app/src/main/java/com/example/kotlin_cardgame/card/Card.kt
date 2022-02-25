package com.example.kotlin_cardgame.card

import com.example.kotlin_cardgame.exception.InvalidCardNumberException

/*
 * 사과 카드에 숫자가 다를 수 있으므로 객체를 여러개 생성할 수 있는 class를 선택했고,
 * 4가지 종류만 선택할 수 있으므로 sealed class를 선택했다.
 * enum 클래스는 하나의 인스턴스만 생성할 수 있고 변경할 수 없으므로 넘버가 여러개인 경우
 * 관리하기 힘들기 때문에 사용하지 않았다.
 */
sealed class Card constructor(number: Int, private val emoji: String) {
    var cardNumber: String = ""
    init {
        cardNumber = checkAndConvertNumber(number)
    }

    data class Apple(private val number: Int) : Card(number, "🍏")
    data class Orange(private val number: Int) : Card(number, "🍊")
    data class Cherry(private val number: Int) : Card(number, "🍒")
    data class Grape(private val number: Int) : Card(number, "🍇")

    fun getCardInfo(): String {
        return emoji + cardNumber
    }

    private fun checkInvalidCardNumber(number: Int) {
        if (number !in 1..10) throw InvalidCardNumberException("1~10까지만 가능합니다.")
    }

    private fun checkAndConvertNumber(number: Int): String {
        checkInvalidCardNumber(number)
        return when (number) {
            1 -> "A"
            10 -> "X"
            else -> number.toString()
        }
    }
}
