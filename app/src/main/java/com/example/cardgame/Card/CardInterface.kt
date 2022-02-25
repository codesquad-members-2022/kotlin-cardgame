package com.example.cardgame.Card

interface CardInterface {
    fun count() : Int
    fun shuffle()
    fun removeOne() :String
    fun reset()
    fun returnScore() : Int
}