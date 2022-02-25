package com.codesquad_Han.kotlin_cardgame.cardmission.cardDeck

import com.codesquad_Han.kotlin_cardgame.cardmission.card.Card
import com.codesquad_Han.kotlin_cardgame.cardmission.cardListMaker.BaseCardListMaker

class CardDeck(override var initialCardNum: Int, cardListMaker: BaseCardListMaker) : BaseCardDeck {

    override var deck: ArrayList<Card> = cardListMaker.makeCardList(initialCardNum)
    private var deckOriginal = ArrayList<Card>()

    init {
        deckOriginal.addAll(deck) // 단순히 '=' 연산자를 통한 대입은 얕은 복사로 서로 영향을 받게된다
    }

    override fun count() = deck.size

    override fun shuffle() {
        if (deck.size > 0) {

        } else {
            println("덱에 카드가 0장 있으므로 셔플이 불가능합니다")
        }
    }

    override fun removeOne() {
        if (deck.size < 1) {
            println("덱에 카드가 0장 있으므로 제거가 불가능합니다")
        } else {
            deck.removeAt((0 until deck.size).random())
        }
    }

    override fun reset() {
        deck.clear()
        deck.addAll(deckOriginal)
    }

    fun printAllCard() {
        println("current card deck state")
        deck.forEach {
            it.printCard()
        }
        println("/////////////////")
        println("initial card deck state")
        deckOriginal.forEach {
            it.printCard()
        }
    }
}