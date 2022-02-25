package com.example.cardgame.Card

const val TWOCARD: Char = 'a'
const val THREECARD: Char = 'b'

class Card(private var cardCount: Int) : CardInterface {

    var cardDeck = mutableListOf<String>()
    var score = mutableListOf<Int>()

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
        var temp = getRandomNumber()
        score.add(temp)
        val number: String = when (temp) {
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

    override fun returnScore(): Int {
        if (score.isEmpty()) {
            return -1
        }
        var cardScore = score[score.size - 1]
        score.removeAt(score.size - 1)
        return cardScore
    }

    override fun reset() {
        initCard()
        println("카드를 초기화 했습니다. ${cardCount}개의 카드가 있습니다.")
    }
}

fun main() {
    val card = Card(40)
    card.reset()

    var user1 = User()
    var user2 = User()
    var user3 = User()
    var robot = User()
    robot.name = "로봇"

    val cardMode = THREECARD
    if (cardMode == TWOCARD) {
        repeat(2) {
            user1.userDeck.add(card.removeOne())
            user1.score += card.returnScore()

            user2.userDeck.add(card.removeOne())
            user2.score += card.returnScore()

            user3.userDeck.add(card.removeOne())
            user3.score += card.returnScore()

            robot.userDeck.add(card.removeOne())
            robot.score += card.returnScore()
        }
    } else {
        repeat(3) {
            user1.userDeck.add(card.removeOne())
            user1.score += card.returnScore()

            user2.userDeck.add(card.removeOne())
            user2.score += card.returnScore()

            user3.userDeck.add(card.removeOne())
            user3.score += card.returnScore()

            robot.userDeck.add(card.removeOne())
            robot.score += card.returnScore()
        }
    }
    println("${user1.name} : ${user1.userDeck} , ${user1.score}")
    println("${user2.name} : ${user2.userDeck}, ${user2.score}")
    println("${user3.name} : ${user3.userDeck}, ${user3.score}")
    println("${robot.name} : ${robot.userDeck}, ${robot.score}")
}