package com.codesquad.kotilin_cardgame

import CardDeck
import CardGame
import User
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class TwoCardGame : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_twocard_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardDeck = CardDeck(40)
        val twoCardGame = CardGame(2, cardDeck)
        twoCardGame.giveOutCard()
        val playerOne = twoCardGame.userList[0]
        val playerTwo = twoCardGame.userList[1]
        val playerThree = twoCardGame.userList[2]
        val playerRobot = twoCardGame.robot
        val playerOneNameView = view.findViewById<TextView>(R.id.tv_player_one)
        val playerTwoNameView = view.findViewById<TextView>(R.id.tv_player_two)
        val playerThreeNameView = view.findViewById<TextView>(R.id.tv_player_three)
        val playerRobotNameView = view.findViewById<TextView>(R.id.tv_player_robot)
        val playerOneFirstCard = view.findViewById<Button>(R.id.btn_player1_card1)
        val playerOneSecondCard = view.findViewById<Button>(R.id.btn_player1_card2)
        val playerOneMedal = view.findViewById<Button>(R.id.btn_player1_medal)
        val playerTwoFirstCard = view.findViewById<Button>(R.id.btn_player2_card1)
        val playerTwoSecondCard = view.findViewById<Button>(R.id.btn_player2_card2)
        val playerTwoMedal =view.findViewById<Button>(R.id.btn_player2_medal)
        val playerThreeFirstCard = view.findViewById<Button>(R.id.btn_player3_card1)
        val playerThreeSecondCard = view.findViewById<Button>(R.id.btn_player3_card2)
        val playerThreeMedal = view.findViewById<Button>(R.id.btn_player3_medal)
        val playerRobotFirstCard = view.findViewById<Button>(R.id.btn_robot_card1)
        val playerRobotSecondCard = view.findViewById<Button>(R.id.btn_robot_card2)
        val playerRobotThirdCard = view.findViewById<Button>(R.id.btn_robot_card3)
        val playerRobotMedal = view.findViewById<Button>(R.id.btn_robot_medal)
        giveOutTwoCard(playerOne, playerOneNameView, playerOneFirstCard, playerOneSecondCard)
        giveOutTwoCard(playerTwo, playerTwoNameView, playerTwoFirstCard,playerTwoSecondCard)
        giveOutTwoCard(playerThree, playerThreeNameView, playerThreeFirstCard, playerThreeSecondCard)
        giveOutCardRobot(playerRobot, playerRobotNameView, playerRobotFirstCard, playerRobotSecondCard, playerRobotThirdCard)
       
    }

    fun giveOutTwoCard(
        user: User,
        userNameView: TextView,
        firstCard: Button,
        secondCard: Button
    ) {
        userNameView.text = user.userName
        firstCard.text= user.userDeck.cardDeck[0].toString()
        secondCard.text= user.userDeck.cardDeck[1].toString()

    }
    fun giveOutCardRobot(
        user: User,
        userNameView: TextView,
        firstCard: Button,
        secondCard: Button,
        thirdCard:Button
    ) {
        userNameView.text = "Robot"
        firstCard.text= user.userDeck.cardDeck[0].toString()
        secondCard.text= user.userDeck.cardDeck[1].toString()
        thirdCard.text= user.userDeck.cardDeck[2].toString()

    }





}