package com.codesquad.kotilin_cardgame

import CardDeck
import CardGame
import User
import org.junit.Test

import org.junit.Assert.*

class CardDeckTest {
    private val startCardDeckSize= 40
    private val userCount =3
    private val robotCount=1

    @Test
    fun testCheckRandomUserName(){
        val userList= Array<User>(3){User(0)}
        userList[0].userName="Linus"
        userList[1].userName="Stark"
        userList[2].userName="Hede"
        assertEquals(true,CardGame.checkDuplicate(userList))
        assertEquals(true, CardGame.checkOnlyAlphabet(userList))
        assertEquals(true, CardGame.checkUserNameLength(userList))
        assertEquals(CardGame.checkDuplicate(userList)&&CardGame.checkOnlyAlphabet(userList)&&CardGame.checkUserNameLength(userList), CardGame.checkUserName(userList))
    }

    @Test
    fun testTwoDrawMode(){
        val cardDeck= CardDeck(startCardDeckSize)
        var remainCard= startCardDeckSize
        val drawNum=2
        val oneDrawNeedCard= drawNum*userCount + robotCount*3
        val twoDrawCardGame= CardGame(drawNum,cardDeck)
        while(cardDeck.count()>= oneDrawNeedCard){
            remainCard-=oneDrawNeedCard
            assertEquals(remainCard, twoDrawCardGame.giveOutCard())
            assertEquals(true, twoDrawCardGame.checkUserGetDrawCard())
        }
    }

    @Test
    fun testThreeDrawMode(){
        val cardDeck= CardDeck(startCardDeckSize)
        var remainCard= startCardDeckSize
        val drawNum=3
        val oneDrawNeedCard= drawNum*userCount + robotCount*3
        val threeDrawCardGame= CardGame(drawNum,cardDeck)
        while(cardDeck.count()>= oneDrawNeedCard){
            remainCard-=oneDrawNeedCard
            assertEquals(remainCard, threeDrawCardGame.giveOutCard())
            assertEquals(true, threeDrawCardGame.checkUserGetDrawCard())
        }
    }

    @Test
    fun testFourDrawMode(){
        val cardDeck= CardDeck(startCardDeckSize)
        var remainCard= startCardDeckSize
        val drawNum=4
        val oneDrawNeedCard= drawNum*userCount + robotCount*3
        val fourDrawCardGame= CardGame(drawNum,cardDeck)
        while(cardDeck.count()>= oneDrawNeedCard){
            remainCard-=oneDrawNeedCard
            assertEquals(remainCard, fourDrawCardGame.giveOutCard())
            assertEquals(true, fourDrawCardGame.checkUserGetDrawCard())
        }
    }

}