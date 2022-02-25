package com.codesquad.kotlincardgame.player

import com.codesquad.kotlincardgame.card.CardDeck

abstract class Player {
    abstract val name: Name

    abstract val cards: CardDeck

    fun take(cards: CardDeck) {
        this.cards.replace(cards)
    }

    open fun score(): Int {
        return cards.sum()
    }
}