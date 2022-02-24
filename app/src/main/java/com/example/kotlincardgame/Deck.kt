package com.example.kotlincardgame

interface Deck {
    fun count(): Int
    fun shuffle()
    fun removeOne(): Card
    fun reset()
}