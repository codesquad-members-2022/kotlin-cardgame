package com.codesquad_Han.kotlin_cardgame.cardmission.cardDeck

import com.codesquad_Han.kotlin_cardgame.cardmission.card.Card

interface BaseCardDeck {
    var deck: ArrayList<Card>
    var initialCardNum: Int
    fun count(): Int
    fun shuffle()
    fun removeOne()
    fun reset()
}