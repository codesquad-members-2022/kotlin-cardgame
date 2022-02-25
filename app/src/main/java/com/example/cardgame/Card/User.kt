package com.example.cardgame.Card

class User() {
    var name:String = randomName()
    val userDeck = mutableListOf<String>()
    var score = 0

    private fun randomName():String{
        val length= (3..5).random()
        return getRandomString(length)
    }

    private fun getRandomString(length: Int) : String {
        val chars = ('A'..'Z')
        return (1..length)
            .map { chars.random() }
            .joinToString("")
    }
}
