package com.codesquard.kotlincardgame

fun main() {
    val startScenario = InputScenario()
    startScenario.testScenario()
}

class InputScenario {
    val scenarioArray = arrayOf("카드 초기화", "카드 섞기", "카드 뽑기", "카드 보기")
    var input = ""
    val test = Test(FruitsCardDeck(AppleCard(), OrangeCard(), CherryCard(), GrapeCard()))

    fun showScenario() {
        println("원하시는 시나리오를 선택해주세요")
        scenarioArray.forEach {
            print("$it|")
        }
        println()
        println("순서대로 1, 2, 3, 4을 고르시고 종료는 q를 눌러주세요")
    }

    fun testScenario() {
        showScenario()
        while (true) {
            input = readLine()!!
            when (input) {
                "1" -> test.initCardDeck()
                "2" -> test.shuffleCard()
                "3" -> test.drawCard()
                "4" -> test.printCardInfo()
                else -> break
            }
        }
    }

}

class Test(private val cardDeck: CardDeck) {

    private fun printTotalCard() {
        println("총 ${cardDeck.count()}장의 카드가 있습니다.")
    }

    fun initCardDeck() {
        cardDeck.reset()
        printTotalCard()
    }

    fun shuffleCard() {
        cardDeck.shuffle()
        println("전체 ${cardDeck.count()}장 카드를 섞었습니다.")
    }

    fun drawCard() {
        val drawnCard = cardDeck.removeOne()
        drawnCard.printCardInfo()
        printTotalCard()
    }

    fun printCardInfo() {
        cardDeck.cardDeck.forEach {
            it.printCardInfo()
        }
    }

}