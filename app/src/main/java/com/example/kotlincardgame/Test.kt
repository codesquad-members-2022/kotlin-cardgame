package com.example.kotlincardgame

import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

fun test(){
    //Logger.addLogAdapter(AndroidLogAdapter())
    val apple = Card.Apple(1)
    val cherry = Card.Cherry(10)
    val grape = Card.Grape(5)
    val orange = Card.Orange(3)
    println("${getCard(apple)}, ${getCard(cherry)}, ${getCard(grape)}, ${getCard(orange)}")
}
fun main() {
    test()
}