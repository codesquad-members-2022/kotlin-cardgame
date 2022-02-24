package com.codesquad_Han.kotlin_cardgame

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.codesquad_Han.kotlin_cardgame.model.CharacterData
import com.google.android.material.bottomnavigation.BottomNavigationView

class GameNavigationActivity : AppCompatActivity() {

    private val gameNavigationViewModel: GameNavigationViewModel by viewModels()
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_for_navigation)

        val characterData = intent.getSerializableExtra("characterData") as CharacterData
        Log.d("AppTest", "$this/ ${characterData.nickName}, ${characterData.byteArray}")
        gameNavigationViewModel.characterNickname = characterData.nickName
        gameNavigationViewModel.characterImageByteArray = characterData.byteArray

        bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_game)
        //bottomNavigationView.itemIconTintList = null

        bottomNavigationView.selectedItemId = R.id.navigation_game_option
        val navController =
            supportFragmentManager.findFragmentById(R.id.container_game_nav)?.findNavController()
        navController?.let {
            // null 이 아닌 경우
            bottomNavigationView.setupWithNavController(it)
        }
    }


}