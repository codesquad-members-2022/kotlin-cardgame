package com.codesquad.kotlincardgame.card

/**
 * Card class(suit, rank)
 * Suit class: 4가지 속성이 정해졌기 때문에 enum 채택
 * Rank class: 점수가 1~10 유한하기 때문에 enum 채택
 * toString Override: 카드 정보출력을 위해 오버라이딩 선택
 */
data class Card(private val suit: Suit, val rank: Rank) {
    override fun toString(): String {
        return "${rank.rank}\n${suit.suit}"
    }
}