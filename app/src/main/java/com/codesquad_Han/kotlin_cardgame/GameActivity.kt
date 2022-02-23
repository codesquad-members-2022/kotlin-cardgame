package com.codesquad_Han.kotlin_cardgame

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.codesquad_Han.kotlin_cardgame.model.CharacterData
import com.google.android.material.bottomnavigation.BottomNavigationView

class GameActivity : AppCompatActivity() {

    private val gameViewModel : GameViewModel by viewModels()
    private lateinit var bottomNavigationView: BottomNavigationView
    val gamePlayFragment = GamePlayFragment()
    val gameOptionFragment = GameOptionFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val characterData = intent.getSerializableExtra("characterData") as CharacterData
        Log.d("AppTest", "${characterData.nickName}, ${characterData.byteArray}")
        gameViewModel.characterNickname = characterData.nickName
        gameViewModel.characterImageByteArray = characterData.byteArray

       bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_game)
       //bottomNavigationView.itemIconTintList = null

        bottomNavigationView.selectedItemId = R.id.navigation_game_option
        initBottomNavigationView(characterData)
    }

    fun initBottomNavigationView(characterData : CharacterData){
        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_game_play ->
                    supportFragmentManager.beginTransaction().replace(R.id.container_game, gamePlayFragment).commit()
                R.id.navigation_game_option ->{
                    supportFragmentManager.beginTransaction().replace(R.id.container_game, gameOptionFragment).commit()
                }
            }
            true
        }
    }


}