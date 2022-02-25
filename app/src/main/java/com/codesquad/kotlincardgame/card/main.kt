package com.codesquad.kotlincardgame.card

import com.codesquad.kotlincardgame.player.PlayerFactory
import com.codesquad.kotlincardgame.ui.InputView
import com.codesquad.kotlincardgame.ui.OutputView
import java.lang.IllegalArgumentException

class CardGame() {

    fun run() {
        InputView.askGameModeSelection()
        var cards = CardFactory.createCards()
        val players = PlayerFactory.createPlayers()

        while (true) {
            val input =
                InputView.execute() ?: throw IllegalArgumentException(NULL_EXCEPTION_MESSAGE)
            val gameMode = GameMode.values(input)
            if (!cards.enoughCards(gameMode)) return
            for (idx in 0 until players.size - 1) {
                val playerCards = cards.remove(gameMode.gameMode)
                players[idx].take(playerCards)
                OutputView.printPlayerInformation(players[idx])
            }
            val robotCards = cards.remove(3)
            players[players.lastIndex].take(robotCards)
            OutputView.printPlayerInformation(players[players.lastIndex])
        }
    }

    companion object {
        private const val NULL_EXCEPTION_MESSAGE = "null 값은 들어올 수 없습니다."
    }
}

fun main() {
    CardGame().run()
}