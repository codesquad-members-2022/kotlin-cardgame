package com.codesquad.kotlincardgame

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.codesquad.kotlincardgame.card.CardGame
import com.codesquad.kotlincardgame.player.Player
import kotlin.math.roundToInt

class GameFragment : Fragment() {

    lateinit var cardGame: CardGame
    lateinit var player1: LinearLayout
    lateinit var player1Name: TextView
    lateinit var player2: LinearLayout
    lateinit var player2Name: TextView
    lateinit var player3: LinearLayout
    lateinit var player3Name: TextView
    lateinit var robot: LinearLayout
    lateinit var robotName: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val actionBar = (activity as SecondActivity).supportActionBar
        actionBar?.title = "과일 카드 게임"
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        player1 = view.findViewById<LinearLayout>(R.id.layout_player1)
        player1Name = view.findViewById<TextView>(R.id.tv_player1)
        player2 = view.findViewById<LinearLayout>(R.id.layout_player2)
        player2Name = view.findViewById<TextView>(R.id.tv_player2)
        player3 = view.findViewById<LinearLayout>(R.id.layout_player3)
        player3Name = view.findViewById<TextView>(R.id.tv_player3)
        robot = view.findViewById<LinearLayout>(R.id.layout_robot)
        robotName = view.findViewById<TextView>(R.id.tv_robot)
        val toggleButtonCard2 = view.findViewById<ToggleButton>(R.id.tb_2_cards)
        val toggleButtonCard3 = view.findViewById<ToggleButton>(R.id.tb_3_cards)
        val toggleButtonCard4 = view.findViewById<ToggleButton>(R.id.tb_4_cards)

        toggleButtonCard2.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                cardGame = CardGame(2)
                toggleButtonCard3.isChecked = false
                toggleButtonCard4.isChecked = false
                updateBoard()
            } else {
                removeView(player1, player2, player3, robot)
                removeName(player1Name, player2Name, player3Name, robotName)
            }
        }

        toggleButtonCard3.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                cardGame = CardGame(3)
                toggleButtonCard2.isChecked = false
                toggleButtonCard4.isChecked = false
                updateBoard()
            } else {
                removeView(player1, player2, player3, robot)
                removeName(player1Name, player2Name, player3Name, robotName)
            }
        }

        toggleButtonCard4.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                cardGame = CardGame(4)
                toggleButtonCard2.isChecked = false
                toggleButtonCard3.isChecked = false
                updateBoard()
            } else {
                removeView(player1, player2, player3, robot)
                removeName(player1Name, player2Name, player3Name, robotName)
            }
        }
    }

    private fun updateBoard() {
        val players = cardGame.players()
        val maxScore = cardGame.maxScore(players)
        removeView(player1, player2, player3, robot)
        removeName(player1Name, player2Name, player3Name, robotName)
        addCards(players[0], player1, player1Name, cardGame.mode, maxScore)
        addCards(players[1], player2, player2Name, cardGame.mode, maxScore)
        addCards(players[2], player3, player3Name, cardGame.mode, maxScore)
        addCards(players[3], robot, robotName, 3, maxScore)
    }

    private fun removeName(
        player1Name: TextView,
        player2Name: TextView,
        player3Name: TextView,
        robotName: TextView
    ) {
        player1Name.text = ""
        player2Name.text = ""
        player3Name.text = ""
        robotName.text = ""
    }

    private fun removeView(
        player1: LinearLayout,
        player2: LinearLayout,
        player3: LinearLayout,
        robot: LinearLayout,
    ) {
        player1.removeAllViews()
        player2.removeAllViews()
        player3.removeAllViews()
        robot.removeAllViews()
    }

    private fun addCards(
        player: Player,
        playerLayout: LinearLayout,
        playerName: TextView,
        numberOfCard: Int,
        maxScore: Int
    ) {
        val dp15 = (resources.displayMetrics.density * 15).roundToInt()
        val dp10 = (resources.displayMetrics.density * 10).roundToInt()
        val dp40 = (resources.displayMetrics.density * 40).roundToInt()
        playerName.text = player.name.name
        repeat(numberOfCard) {
            val textView = TextView(activity)
            textView.text = player.cards.cards[it].toString()
            textView.gravity = Gravity.CENTER
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.rightMargin = dp10
            textView.setPadding(dp15, dp15, dp15, dp10)
            textView.setBackgroundResource(R.drawable.card_background)
            textView.layoutParams = layoutParams
            playerLayout.addView(textView)
        }
        if (maxScore == player.cards.sum() && player.name.name != "로봇") {
            val imageView = ImageView(activity)
            val layoutParams = LinearLayout.LayoutParams(dp40, dp40)
            layoutParams.topMargin = dp10
            imageView.setBackgroundResource(R.drawable.ic_medal_1369)
            imageView.layoutParams = layoutParams
            playerLayout.addView(imageView)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_bar_refresh -> {
                cardGame.reset()
                updateBoard()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}