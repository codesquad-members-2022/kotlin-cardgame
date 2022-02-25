package com.example.cardgame

class Card(private var cardCount: Int) : CardInterface {

    var cardDeck = mutableListOf<String>()

    private fun getRandomShape(): String {
        return when ((1..4).random()) {
            1 -> Shape.APPLE.shape
            2 -> Shape.ORANGE.shape
            3 -> Shape.CHERRY.shape
            else -> Shape.GRAPE.shape
        }
    }

    private fun initCard() {
        repeat(cardCount) {
            cardDeck.add(returnCard())
        }
    }

    private fun getRandomNumber(): Int {
        return (1..10).random()
    }

    private fun returnCard(): String {
        val number: String
        val temp = getRandomNumber()
        number = when (temp) {
            1 -> Number.A.toString()
            10 -> Number.X.toString()
            else -> temp.toString()
        }

        val shape: String = getRandomShape()
        return shape + number
    }

    override fun count(): Int {
        return cardDeck.size
    }

    override fun shuffle() {
        var i = cardDeck.size
        while (i > 1) {
            i -= 1
            var j = (1..i).random()
            val temp = cardDeck[j]
            cardDeck[j] = cardDeck[i]
            cardDeck[i] = temp
        }
    }

    override fun removeOne(): String {
        if (cardDeck.isEmpty()) {
            return "남은 카드가 더 이상 없습니다."
        }
        val card = cardDeck[cardDeck.size - 1]
        cardDeck.removeAt(cardDeck.size - 1)
        cardCount -= 1
        println("총 ${cardCount}개의 카드가 남아있습니다")
        return card
    }

    override fun reset() {
        initCard()
        println("카드를 초기화 했습니다. ${cardCount}개의 카드가 있습니다.")
    }
}

fun main() {
    val card = Card(10)
    card.reset()
    for (i in 0..10) {
        println(card.removeOne())
    }
}