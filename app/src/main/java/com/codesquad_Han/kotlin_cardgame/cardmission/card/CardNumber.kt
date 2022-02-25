package com.codesquad_Han.kotlin_cardgame.cardmission.card

class CardNumber(number: Int) {
    private var number = number

    fun getNumberForPrint() : String{
        if(number == 1) return "A"
        else if(number == 10) return "X"
        else return number.toString()
    }
}