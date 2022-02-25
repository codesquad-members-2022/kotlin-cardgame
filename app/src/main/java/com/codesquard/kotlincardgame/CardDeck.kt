package com.codesquard.kotlincardgame

import kotlin.math.floor

fun main() {
}

interface CardDeck {
    val cardDeck: ArrayList<Card>
    fun count(): Int
    fun shuffle()
    fun removeOne(): Card
    fun reset()
}

class FruitsCardDeck(vararg card: Card) : CardDeck {
    private val initialCardDeck = arrayListOf<Card>()
    override var cardDeck = arrayListOf<Card>()

    init {
        card.forEach {
            CardNumber.numberArray.forEachIndexed { index, _ ->
                it.setNumber(index)
                initialCardDeck.add(it.clone())
            }
        }
        cardDeck = initialCardDeck
    }

    override fun count() = cardDeck.size

    override fun shuffle() {
        for (i in cardDeck.indices) {
            val random = floor(Math.random() * (i + 1)).toInt()
            val tem = cardDeck[i]
            cardDeck[i] = cardDeck[random]
            cardDeck[random] = tem
        }
    }

    override fun removeOne(): Card {
        val givenCard = cardDeck[cardDeck.size - 1]
        cardDeck.removeAt(cardDeck.size - 1)
        return givenCard
    }

    override fun reset() {
        cardDeck = initialCardDeck
    }
}