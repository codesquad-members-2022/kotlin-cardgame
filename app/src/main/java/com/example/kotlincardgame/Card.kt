package com.example.kotlincardgame

// 상수를 쓰는 enum 보다는 sealed class가 숫자까지 넣기에는 편할거 같았고
// 확장성도 좋아보여서 seales class를 사용하였습니다.
// 그리고 그안에서 카드의 데이터(숫자)를 저장이필요해서 data class로 상속받았습니다.
fun Card.getCard() = when (this) {
    is Card.Apple -> "🍎${this.get()}"
    is Card.Orange -> "🍊${this.get()}"
    is Card.Cherry -> "🍒${this.get()}"
    is Card.Grape -> "🍇${this.get()}"
}
sealed class Card {
    data class Apple(private val number: Int) : Card() {
        fun get() = when (number) {
            1 -> "A"
            10 -> "X"
            else -> number
        }
    }

    class Orange(private val number: Int) : Card() {
        fun get() = when (number) {
            1 -> "A"
            10 -> "X"
            else -> number
        }
    }

    class Cherry(private val number: Int) : Card() {
        fun get() = when (number) {
            1 -> "A"
            10 -> "X"
            else -> number
        }
    }

    class Grape(private val number: Int) : Card() {
        fun get() = when (number) {
            1 -> "A"
            10 -> "X"
            else -> number
        }
    }

}


