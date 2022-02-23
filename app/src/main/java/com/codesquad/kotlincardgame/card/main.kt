package com.codesquad.kotlincardgame.card

import com.codesquad.kotlincardgame.card.Rank.*
import com.codesquad.kotlincardgame.card.Suit.*

fun main() {
    val card = Card(CHERRY, TEN)
    val card2 = Card(APPLE, SEVEN)
    println(card)
    println(card2)
}