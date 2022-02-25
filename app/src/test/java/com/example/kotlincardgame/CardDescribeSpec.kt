package com.example.kotlincardgame

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class CardDescribeSpec : DescribeSpec({

    describe("number") {
        context("number이 입력되면") {
            it("카드 번호가 반환된다") {
                cardNumber.forAll {
                    val apple = Card.Apple(it)
                    val result = apple.number
                    result shouldBe it
                }
            }
        }

        context("number이 입력되면") {
            it("카드 번호가 반환된다") {
                cardNumber.forAll {
                    val apple = Card.Cherry(it)
                    val result = apple.number
                    result shouldBe it
                }
            }
        }

        context("number이 입력되면") {
            it("카드 번호가 반환된다") {
                cardNumber.forAll {
                    val apple = Card.Grape(it)
                    val result = apple.number
                    result shouldBe it
                }
            }
        }

        context("number이 입력되면") {
            it("카드 번호가 반환된다") {
                cardNumber.forAll {
                    val apple = Card.Orange(it)
                    val result = apple.number
                    result shouldBe it
                }
            }
        }
    }

}) {
    companion object {
        val cardNumber = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }
}
