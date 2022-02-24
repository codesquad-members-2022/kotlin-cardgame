package com.codesquad.kotlincardgame.player

import com.codesquad.kotlincardgame.card.CardDeck

class Participant : Player() {
    override val name: Name = Name(Name.getRandomName())

    override val cards: CardDeck = CardDeck()
}