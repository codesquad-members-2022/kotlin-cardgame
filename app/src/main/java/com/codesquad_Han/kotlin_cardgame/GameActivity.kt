package com.codesquad_Han.kotlin_cardgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

       val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_game)
        bottomNavigationView.itemIconTintList = null
    }
}