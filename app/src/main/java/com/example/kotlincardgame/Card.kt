package com.example.kotlincardgame

fun Card.getCard() = when (this) {
    is Card.Apple -> "🍎${convertNumber(this.number)}"
    is Card.Orange -> "🍊${convertNumber(this.number)}"
    is Card.Cherry -> "🍒${convertNumber(this.number)}"
    is Card.Grape -> "🍇${convertNumber(this.number)}"
}

fun convertNumber(number: Int) = when (number) {
    1 -> "A"
    10 -> "X"
    else -> number
}

// 상수를 쓰는 enum 보다는 sealed class가 숫자까지 넣기에는 편할거 같았고
// 확장성도 좋아보여서 seales class를 사용하였습니다.
// 그리고 그안에서 카드의 데이터(숫자)를 저장이필요해서 data class로 상속받았습니다.
sealed class Card {
    data class Apple(val number: Int) : Card()

    class Orange(val number: Int) : Card()

    class Cherry(val number: Int) : Card()

    class Grape(val number: Int) : Card()

}


