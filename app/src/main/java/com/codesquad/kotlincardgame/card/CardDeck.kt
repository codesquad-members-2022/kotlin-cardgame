package com.codesquad.kotlincardgame.card

class CardDeck(private val _cards: MutableList<Card> = mutableListOf()) {

    fun reset(): CardDeck = makeAllCards()

    fun count(): Int = _cards.size

    fun shuffle(): CardDeck {
        for (i in _cards.indices) {
            val randomIndex = (i.._cards.size).random()
            _cards[i] = _cards[randomIndex].also { _cards[randomIndex] = _cards[i] }
        }
        return CardDeck(_cards)
    }

    fun removeOne(): Card {
        require(_cards.isNotEmpty()) { EMPTY_MESSAGE }
        val randomIndex = (1.._cards.size).random()
        return _cards.removeAt(randomIndex)
    }

    private fun makeAllCards(): CardDeck {
        val cards = mutableListOf<Card>()
        Rank.values().forEach { rank ->
            Suit.values().forEach { suit ->
                cards.add(Card(suit, rank))
            }
        }
        return CardDeck(cards)
    }

    companion object {
        private const val EMPTY_MESSAGE = "비어 있으면 안됩니다."
    }
}