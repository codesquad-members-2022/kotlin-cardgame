package com.codesquad.kotlincardgame.card

import com.codesquad.kotlincardgame.card.Command.*
import com.codesquad.kotlincardgame.ui.InputView
import com.codesquad.kotlincardgame.ui.OutputView
import java.lang.IllegalArgumentException

class CardGame() {

    fun run() {
        OutputView.printInit()
        var cards = CardDeck()

        try {
            while (true) {
                val input =
                    InputView.execute() ?: throw IllegalArgumentException(NULL_EXCEPTION_MESSAGE)
                when (Command.values(input)) {
                    RESET -> {
                        cards = cards.reset()
                        OutputView.printReset(cards.count())
                    }
                    SHUFFLE -> {
                        cards = cards.shuffle()
                        OutputView.printShuffle(cards.count())
                    }
                    REMOVE -> {
                        val card = cards.removeOne()
                        OutputView.printRemain(card, cards.count())
                    }
                    EXIT -> break
                }
            }
        } catch (e: Exception) {
            println(e.message)
            run()
        }
    }

    companion object {
        private const val NULL_EXCEPTION_MESSAGE = "null 값은 들어올 수 없습니다."
    }
}

fun main() {
    CardGame().run()
}