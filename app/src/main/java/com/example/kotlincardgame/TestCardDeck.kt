package com.example.kotlincardgame

class TestCardDeck(_count: Int) : Deck {
    private val count = _count
    private val deck = mutableListOf<Card>()

    init {
        reset()
    }

    private fun Int.selectCard() = when (this) {
        0 -> Card.Apple((1..10).random())
        1 -> Card.Orange((1..10).random())
        2 -> Card.Cherry((1..10).random())
        else -> Card.Grape((1..10).random())
    }
    
    override fun count() = count

    override fun shuffle() {
        TODO("Not yet implemented")
    }

    override fun removeOne(): Card {
        TODO("Not yet implemented")
    }

    override fun reset() {
        for (i in 0 until count) {
            deck.add((0..3).random().selectCard())
        }
    }


}