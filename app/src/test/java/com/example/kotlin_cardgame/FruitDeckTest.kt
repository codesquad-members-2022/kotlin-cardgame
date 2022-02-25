package com.example.kotlin_cardgame

import FruitDeck
import Game
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class FruitDeckTest {


    @Test
    fun count() {
        val fruitDeck = FruitDeck()
        assertEquals(40, fruitDeck.count())
        assertEquals("🍎X", fruitDeck.removeOne().toString())
        assertEquals("🍎9", fruitDeck.removeOne().toString())
        assertEquals(38, fruitDeck.count())
    }

    @Test
    fun shuffle() {
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
    }

    @Test
    fun removeOne() {
        val fruitDeck = FruitDeck()
        repeat(40) { fruitDeck.removeOne() }
        assertEquals(null, fruitDeck.removeOne())
        assertEquals(null, fruitDeck.removeOne())
    }

    @Test
    fun reset() {
        val fruitDeck = FruitDeck()
        repeat(5) { fruitDeck.removeOne() }
        fruitDeck.shuffle()

        fruitDeck.reset()
        assertEquals(40, fruitDeck.count())
        repeat(25) { fruitDeck.removeOne() }
        assertEquals("🍇5", fruitDeck.removeOne().toString())

        repeat(3) { fruitDeck.removeOne() }
        assertEquals("🍇A", fruitDeck.removeOne().toString())
    }
}