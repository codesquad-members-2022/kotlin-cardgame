package com.example.app

import android.icu.text.UnicodeSet
import android.os.Build
import androidx.annotation.RequiresApi


fun main() {
    val test = CardDeckFactory.makeCardDeck()

    println(test.eachCardDeck[0][1])
}

enum class CardDeckShape(val cardSignature: String) {
    APPLE("\uD83C\uDF4F"),
    ORANGE("\uD83C\uDF4A"),
    GRAPE("\uD83C\uDF47"),
    MANGO("\uD83E\uDD6D")
}

class CardDeckFactory {
    data class CardDeck(val eachCardDeck: MutableList<MutableMap<Int, String>>)

    companion object {
        fun makeCardDeck(): CardDeck {
            val eachDeckCount = 10
            val decks = mutableListOf<MutableMap<Int, String>>()
            val appleDeck = mutableMapOf<Int, String>()
            val orangeDeck = mutableMapOf<Int, String>()
            val grapeDeck = mutableMapOf<Int, String>()
            val mangoDeck = mutableMapOf<Int, String>()

            for (i in 0 until eachDeckCount) {
                appleDeck[i] = CardDeckShape.APPLE.cardSignature
                orangeDeck[i] = CardDeckShape.ORANGE.cardSignature
                grapeDeck[i] = CardDeckShape.GRAPE.cardSignature
                mangoDeck[i] = CardDeckShape.MANGO.cardSignature
            }

            decks.add(appleDeck)
            decks.add(orangeDeck)
            decks.add(grapeDeck)
            decks.add(mangoDeck)

            return CardDeck(decks)
        }
    }
}

interface CardGame {
    fun getCardCount(): Int
    fun shuffleCards()
    fun removeOneCard(): MutableMap<Int, String>
    fun resetCardDeck()
}

class CardGameLogicController {

}