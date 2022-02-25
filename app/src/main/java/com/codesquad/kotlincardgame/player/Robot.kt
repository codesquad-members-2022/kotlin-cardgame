package com.codesquad.kotlincardgame.player

import com.codesquad.kotlincardgame.card.CardDeck

class Robot : Player() {
    override val name: Name = Name(ROBOT_NAME)

    override val cards: CardDeck = CardDeck()

    companion object {
        private const val ROBOT_NAME = "로봇"
    }
}