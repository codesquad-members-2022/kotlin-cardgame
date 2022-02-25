package com.example.kotlin_cardgame.card

import kotlin.random.Random
import kotlin.random.nextInt

class CardDeck : CardDeckOperation {
    private var cards = mutableListOf<Card>()
    private var originCards = listOf<Card>()
    private val maxCountPerCard = 10
    private val maxCardCount = 40

    init {
        for (i in 1..maxCountPerCard) cards.add(Card.Apple(i))
        for (i in 1..maxCountPerCard) cards.add(Card.Orange(i))
        for (i in 1..maxCountPerCard) cards.add(Card.Cherry(i))
        for (i in 1..maxCountPerCard) cards.add(Card.Grape(i))

        originCards = cards.toList()
    }

    override fun count(): Int {
        return cards.size
    }

    override fun shuffle() {
        val shuffleCardIndex = randomShuffle()
        val shuffledCards = mutableListOf<Card>()
        for (i in 1..cards.size) {
            val data = shuffleCardIndex[0]
            shuffledCards.add(cards[data])
            shuffleCardIndex.removeAt(0)
        }

        cards = shuffledCards
        originCards = shuffledCards.toList()
    }

    private fun randomShuffle(): MutableList<Int> {
        val numberIndexList = mutableListOf<Int>()
        for (i in 0 until cards.size) {
            numberIndexList.add(i)
        }

        var possibleShuffleCount = cards.size
        val shuffleCardIndex = mutableListOf<Int>()
        while (possibleShuffleCount > 0) {
            val randomPickIndex = pickRandomCardIndex(possibleShuffleCount)
            shuffleCardIndex.add(
                numberIndexList[randomPickIndex]
            )
            numberIndexList.removeAt(randomPickIndex)
            possibleShuffleCount--
        }

        return shuffleCardIndex
    }

    private fun pickRandomCardIndex(end: Int): Int {
        return Random.nextInt(0 until end)
    }

    override fun removeOne(): Card {
        if (count() == 0) {
            throw Exception("더 이상 뽑을 카드가 없습니다.")
        }
        val removeCard = cards.random()
        cards.remove(removeCard)
        return removeCard
    }

    override fun reset() {
        cards = originCards.toMutableList()
    }
}
