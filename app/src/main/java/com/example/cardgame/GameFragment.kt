package com.example.cardgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cardgame.Card.Card
import com.example.cardgame.Card.THREECARD
import com.example.cardgame.Card.TWOCARD
import com.example.cardgame.Card.User

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val actionBar = (activity as SecondActivity).supportActionBar
        actionBar?.title = "게임"

        val card = Card(40)
        card.reset()

        var user1 = User()
        var user2 = User()
        var user3 = User()
        var robot = User()
        robot.name = "로봇"

        //TODO : 반복문 배열 활용하여 코드길이를 줄이자
        val cardMode = TWOCARD
        if (cardMode == TWOCARD) {
            repeat(2) {
                user1.userDeck.add(card.removeOne())
                user1.score += card.returnScore()

                user2.userDeck.add(card.removeOne())
                user2.score += card.returnScore()

                user3.userDeck.add(card.removeOne())
                user3.score += card.returnScore()

                robot.userDeck.add(card.removeOne())
                robot.score += card.returnScore()
            }
            val player1 = view.findViewById<TextView>(R.id.player1)
            val player1Card1 = view.findViewById<TextView>(R.id.player1Card1)
            val player1Card2 = view.findViewById<TextView>(R.id.player1Card2)
            player1.setText(user1.name)
            player1Card1.setText(user1.userDeck[0])
            player1Card2.setText(user1.userDeck[1])

            val player2 = view.findViewById<TextView>(R.id.player2)
            val player2Card1 = view.findViewById<TextView>(R.id.player2Card1)
            val player2Card2 = view.findViewById<TextView>(R.id.player2Card2)
            player2.setText(user2.name)
            player2Card1.setText(user2.userDeck[0])
            player2Card2.setText(user2.userDeck[1])

            val player3 = view.findViewById<TextView>(R.id.player3)
            val player3Card1 = view.findViewById<TextView>(R.id.player3Card1)
            val player3Card2 = view.findViewById<TextView>(R.id.player3Card2)
            player3.setText(user3.name)
            player3Card1.setText(user3.userDeck[0])
            player3Card2.setText(user3.userDeck[1])

            val player4 = view.findViewById<TextView>(R.id.player4)
            val player4Card1 = view.findViewById<TextView>(R.id.player4Card1)
            val player4Card2 = view.findViewById<TextView>(R.id.player4Card2)
            player4.setText(robot.name)
            player4Card1.setText(robot.userDeck[0])
            player4Card2.setText(robot.userDeck[1])
        } else {
        }
    }
}