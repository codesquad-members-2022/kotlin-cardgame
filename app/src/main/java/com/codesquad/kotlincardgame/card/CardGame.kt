package com.codesquad.kotlincardgame.card

import com.codesquad.kotlincardgame.player.Player
import com.codesquad.kotlincardgame.player.PlayerFactory

class CardGame(
    val mode: Int,
    private var cards: CardDeck = CardFactory.createCards()
) {

    private val gameMode: GameMode = GameMode.values(mode.toString())

    init {
        require(cards.enoughCards(gameMode)) { NOT_ENOUGH_CARD }
    }

    fun reset() {
        cards = cards.reset()
    }

    fun players(): List<Player> {
        val players = PlayerFactory.createPlayers()
        for (idx in 0 until players.size - 1) {
            val playerCards = cards.remove(gameMode.gameMode)
            players[idx].take(playerCards)
        }
        val robotCards = cards.remove(3)
        players[players.lastIndex].take(robotCards)
        return players
    }

    fun maxScore(players: List<Player>): Int {
        var maxScore = 0
        for (i in 0 until players.size - 1) {
            val score = players[i].score()
            maxScore = maxScore.coerceAtLeast(score)
        }
        return maxScore
    }

    companion object {
        private const val NOT_ENOUGH_CARD = "카드가 충분하지 않습니다."
    }
}