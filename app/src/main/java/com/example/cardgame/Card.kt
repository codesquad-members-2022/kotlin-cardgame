package com.example.cardgame

class Card {
    private fun getRandomShape(): String {
        return when ((1..4).random()) {
            1 -> Shape.APPLE.shape
            2 -> Shape.ORANGE.shape
            3 -> Shape.CHERRY.shape
            else -> Shape.GRAPE.shape
        }
    }

    private fun getRandomNumber(): Int {
        return (1..10).random()
    }

    fun returnCard(): String {
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
}

fun main() {
    val card = Card()
    for (i in 0..10) {
        println(card.returnCard())
    }
}