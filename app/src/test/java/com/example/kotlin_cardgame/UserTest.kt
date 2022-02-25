package com.example.kotlin_cardgame

import FruitCard
import FruitDeck
import Game
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UserTest {

    @Test
    fun getCardState() {
        val user = User(null)
        val card1 = FruitCard(FruitEnum.CHERRY, 10)
        val card2 = FruitCard(FruitEnum.ORANGE, 1)
        val card3 = FruitCard(FruitEnum.GRAPE, 8)

        user.addCardList(card1)
        user.addCardList(card2)
        user.addCardList(card3)
        val result = StringBuilder()
        result .append(user.userName + " // ")
        result.append(" \uD83C\uDF52X ")
        result.append(" \uD83C\uDF4AA ")
        result.append(" \uD83C\uDF478 ")

        assertEquals(result.toString(), user.getCardState())
    }

}