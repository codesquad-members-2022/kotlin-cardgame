package com.example.kotlin_cardgame.card

interface CardDeckOperation {
    fun count(): Int
    fun shuffle()
    fun removeOne(): Card
    fun reset()
}
