package com.example.kotlincardgame

fun test() {
    //Logger.addLogAdapter(AndroidLogAdapter())
    val apple = Card.Apple(1)
    val cherry = Card.Cherry(10)
    val grape = Card.Grape(5)
    val orange = Card.Orange(3)
    println("${apple.getCard()}, ${cherry.getCard()}, ${grape.getCard()}, ${orange.getCard()}")
    val deck = TestCardDeck(40)
    println("카드는 ${deck.count()}개")
    println("카드 하나 뽑기")
    println("${deck.removeOne().getCard()}")
    println("카드 하나 뽑기")
    println("${deck.removeOne().getCard()}")
    println("카드 하나 뽑기")
    println("${deck.removeOne().getCard()}")
    println("리셋")
    deck.reset()
    println("카드는 ${deck.count()}개")

}

fun main() {
    test()
}