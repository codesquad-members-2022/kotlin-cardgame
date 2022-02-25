package com.example.kotlin_cardgame

import ICard
import java.lang.StringBuilder

class User(var userName: String?) {

    private val cardList = mutableListOf<ICard>()

    init {
        userName = userName ?: getRandomName()
    }

    fun addCardList(card: ICard) {
        cardList.add(card)
    }

    private fun getRandomName(): String? {
        val nameLength = (2..4).random()
        val nameBuilder = StringBuilder()
        repeat(nameLength) {
            val randChar = (97..122).random().toChar()
            nameBuilder.append(randChar)
        }
        return nameBuilder.toString()
    }

    fun getCardState(): String {
        val userState = StringBuilder(userName)
        userState.append(" // ")
        cardList.forEach {
            userState.append(" $it ")
        }
        return userState.toString()
    }
}