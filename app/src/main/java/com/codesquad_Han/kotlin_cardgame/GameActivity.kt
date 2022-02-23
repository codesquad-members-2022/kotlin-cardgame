package com.codesquad_Han.kotlin_cardgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class GameActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    val gamePlayFragment = GamePlayFragment()
    val gameOptionFragment = GameOptionFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

       bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_game)
       //bottomNavigationView.itemIconTintList = null

        bottomNavigationView.selectedItemId = R.id.navigation_game_option
        initBottomNavigationView()
    }

    fun initBottomNavigationView(){
        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_game_play ->
                    supportFragmentManager.beginTransaction().replace(R.id.container_game, gamePlayFragment).commit()
                R.id.navigation_game_option ->
                    supportFragmentManager.beginTransaction().replace(R.id.container_game, gameOptionFragment).commit()
            }
            true
        }
    }


}