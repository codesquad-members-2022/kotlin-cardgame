package com.codesquad.kotilin_cardgame

import CardDeck
import CardGame
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FourCardGame : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourcard_game, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        giveOutFourCard(view)
    }

    fun giveOutFourCard(view: View){
        val cardDeck= CardDeck(40)
        val fourCardGame = CardGame(4,cardDeck)
        val playerOne= fourCardGame.userList[0]
        val playerTwo= fourCardGame.userList[1]
        val playerThree= fourCardGame.userList[2]
        val playerRobot= fourCardGame.robot
        view.findViewById<TextView>(R.id.tv_player_one).text= playerOne.userName
        view.findViewById<TextView>(R.id.tv_player_two).text= playerTwo.userName
        view.findViewById<TextView>(R.id.tv_player_three).text= playerThree.userName
        view.findViewById<TextView>(R.id.tv_player_robot).text= "Robot"
        fourCardGame.giveOutCard()
        view.findViewById<Button>(R.id.btn_player1_card1).text= playerOne.userDeck.cardDeck[0].toString()
        view.findViewById<Button>(R.id.btn_player1_card2).text= playerOne.userDeck.cardDeck[1].toString()
        view.findViewById<Button>(R.id.btn_player1_card2).text= playerOne.userDeck.cardDeck[2].toString()
        view.findViewById<Button>(R.id.btn_player1_card2).text= playerOne.userDeck.cardDeck[3].toString()
        view.findViewById<Button>(R.id.btn_player2_card1).text= playerTwo.userDeck.cardDeck[0].toString()
        view.findViewById<Button>(R.id.btn_player2_card2).text= playerTwo.userDeck.cardDeck[1].toString()
        view.findViewById<Button>(R.id.btn_player2_card2).text= playerTwo.userDeck.cardDeck[2].toString()
        view.findViewById<Button>(R.id.btn_player2_card2).text= playerTwo.userDeck.cardDeck[3].toString()
        view.findViewById<Button>(R.id.btn_player3_card1).text= playerThree.userDeck.cardDeck[0].toString()
        view.findViewById<Button>(R.id.btn_player3_card2).text= playerThree.userDeck.cardDeck[1].toString()
        view.findViewById<Button>(R.id.btn_player3_card2).text= playerThree.userDeck.cardDeck[2].toString()
        view.findViewById<Button>(R.id.btn_player3_card2).text= playerThree.userDeck.cardDeck[3].toString()
        view.findViewById<Button>(R.id.btn_robot_card1).text= playerRobot.userDeck.cardDeck[0].toString()
        view.findViewById<Button>(R.id.btn_robot_card2).text= playerRobot.userDeck.cardDeck[1].toString()
        view.findViewById<Button>(R.id.btn_robot_card3).text= playerRobot.userDeck.cardDeck[2].toString()
    }

}