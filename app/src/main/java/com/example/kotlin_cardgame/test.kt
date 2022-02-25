import kotlin.random.Random


fun main() {

    val fruitDeck = FruitDeck()

    // init 함수 체크
    assertEquals(40, fruitDeck.count())
    assertEquals("🍎X", fruitDeck.removeOne().toString())
    assertEquals("🍎9", fruitDeck.removeOne().toString())
    assertEquals(38, fruitDeck.count())

    // reset 함수 체크
    fruitDeck.reset()
    assertEquals(40, fruitDeck.count())
    repeat(25) { fruitDeck.removeOne() }
    assertEquals("🍇5", fruitDeck.removeOne().toString())

    repeat(3) { fruitDeck.removeOne() }
    assertEquals("🍇A", fruitDeck.removeOne().toString())

    // removeOne 함수 체크
    fruitDeck.reset()
    repeat(40) { fruitDeck.removeOne() }
    assertEquals(null, fruitDeck.removeOne())
    assertEquals(null, fruitDeck.removeOne())

    // shuffle 함수 체크
    val fruitDeck1 = FruitDeck()
    val fruitDeck2 = FruitDeck()
    val deckSize = fruitDeck1.count()
    var sameCount = 0
    fruitDeck1.shuffle()
    fruitDeck2.shuffle()

    repeat(deckSize) {
        if (fruitDeck1.removeOne() == fruitDeck2.removeOne()) sameCount++
    }

    assertNotEquals(sameCount, deckSize)

    println(User(null).userName)
    println(User(null).userName)
    println(User(null).userName)

    val game  = Game(3, FruitDeck())
    println(game.getUserCardState())
}


