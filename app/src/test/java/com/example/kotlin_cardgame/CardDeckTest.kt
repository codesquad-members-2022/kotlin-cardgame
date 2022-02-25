package com.example.kotlin_cardgame

import com.example.kotlin_cardgame.card.CardDeck

fun main() {
    val cardDeck = CardDeck()
    cardDeck.shuffle()

    var selectMenu = 0
    while (cardDeck.count() != 0) {
        printMenu()
        selectMenu = readLine()!!.toInt()
        command(cardDeck, selectMenu)
    }
}

fun command(cardDeck: CardDeck, selectMenu: Int) {
    when (selectMenu) {
        1 -> {
            cardDeck.reset()
            println("카드를 초기화 했습니다.")
            println("총 ${cardDeck.count()}장의 카드가 있습니다.\n")
        }
        2 -> {
            cardDeck.shuffle()
            println("총 ${cardDeck.count()}장의 카드를 섞었습니다.\n")
        }
        3 -> {
            println(cardDeck.removeOne().getCardInfo())
            println("총 ${cardDeck.count()}장의 카드가 남았습니다.\n")
        }
        else -> {
            println("잘못된 명령어입니다.")
        }
    }
}

fun printMenu() {
    println("1. 카드 초기화")
    println("2. 카드 섞기")
    println("3. 하나 뽑기")
    print("> ")
}