package com.codesquad_Han.kotlin_cardgame.cardmission.cardListMaker

import com.codesquad_Han.kotlin_cardgame.cardmission.card.Card

interface BaseCardListMaker {
    fun makeCardList(cardNum: Int): ArrayList<Card>
}