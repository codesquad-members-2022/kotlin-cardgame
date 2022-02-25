package com.codesquad_Han.kotlin_cardgame.cardmission.cardListMaker

import com.codesquad_Han.kotlin_cardgame.cardmission.card.Card
import com.codesquad_Han.kotlin_cardgame.cardmission.card.CardNumber
import com.codesquad_Han.kotlin_cardgame.cardmission.card.Fruit

class CardListMaker : BaseCardListMaker {
    override fun makeCardList(cardNum: Int) = ArrayList<Card>().apply {
        (1..cardNum).forEach {
            this.add(Card(getRandomFruit(), CardNumber((1..10).random())))
        }
    }

    fun getRandomFruit(): Fruit {
        val a = (1..4).random()
        when (a) {
            1 -> return Fruit.APPLE
            2 -> return Fruit.CHERRY
            3 -> return Fruit.PEACH
            else -> return Fruit.PEAR
        }
    }
}