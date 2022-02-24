package com.codesquad.kotlincardgame.card

object CardFactory {
    fun createCards(): CardDeck {
        val cards = mutableListOf<Card>()
        Rank.values().forEach { rank ->
            Suit.values().forEach { suit ->
                cards.add(Card(suit, rank))
            }
        }
        return CardDeck(cards)
    }
}