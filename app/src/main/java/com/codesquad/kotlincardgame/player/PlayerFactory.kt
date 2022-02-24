package com.codesquad.kotlincardgame.player

object PlayerFactory {
    fun createPlayers(): List<Player> {
        var players = mutableListOf<Player>()
        repeat(PARTICIPANT) {
            players.add(Participant())
        }
        players.add(Robot())
        return players
    }

    const val PARTICIPANT = 3
    const val ROBOT = 1
    const val ROBOT_CARD_COUNT = 3
}