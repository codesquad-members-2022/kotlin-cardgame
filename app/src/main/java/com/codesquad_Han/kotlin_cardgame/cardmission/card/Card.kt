package com.codesquad_Han.kotlin_cardgame.cardmission.card

class Card(fruit: Fruit, cardNumber: CardNumber) {
    private var fruit = fruit
    private var number = cardNumber

    fun printCard(){
        println("${fruit.fruit}${number.getNumberForPrint()}")
    }
}