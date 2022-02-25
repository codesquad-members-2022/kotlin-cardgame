package com.codesquad.kotlincardgame.card

import com.codesquad.kotlincardgame.player.PlayerFactory.PARTICIPANT
import com.codesquad.kotlincardgame.player.PlayerFactory.ROBOT
import com.codesquad.kotlincardgame.player.PlayerFactory.ROBOT_CARD_COUNT

class CardDeck(private var _cards: MutableList<Card> = mutableListOf()) {

    val cards: List<Card>
        get() = _cards.toList()

    fun replace(cards: CardDeck) {
        _cards = cards.cards.toMutableList()
    }

    fun reset(): CardDeck {
        val cardDeck = CardFactory.createCards()
        return cardDeck.shuffle()
    }

    fun count(): Int = _cards.size

    fun sum(): Int {
        var sum = 0
        _cards.forEachIndexed { index, card ->
            when (card.rank.rank) {
                "A" -> sum += 1
                "X" -> sum += 10
                else -> sum += card.rank.rank.toInt()
            }
        }
        return sum
    }

    fun shuffle(): CardDeck {
        for (i in _cards.indices) {
            val randomIndex = (i until _cards.size).random()
            _cards[i] = _cards[randomIndex].also { _cards[randomIndex] = _cards[i] }
        }
        return CardDeck(_cards)
    }

    private fun removeOne(): Card {
        require(_cards.isNotEmpty()) { EMPTY_MESSAGE }
        val randomIndex = (1 until _cards.size).random()
        return _cards.removeAt(randomIndex)
    }

    fun remove(numberOfCards: Int): CardDeck {
        var cards = mutableListOf<Card>()
        repeat(numberOfCards) {
            cards.add(removeOne())
        }
        return CardDeck(cards)
    }

    fun enoughCards(gameMode: GameMode): Boolean {
        val requiredCard = gameMode.gameMode * (PARTICIPANT) + ROBOT * ROBOT_CARD_COUNT
        return _cards.size >= requiredCard
    }

    companion object {
        private const val EMPTY_MESSAGE = "비어 있으면 안됩니다."
    }
}