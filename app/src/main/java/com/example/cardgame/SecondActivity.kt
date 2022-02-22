package com.example.cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cardgame.databinding.SecondActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val text = intent.getStringExtra("nickname")
        val characterChosen = intent.getIntExtra("character",0)

        val bundle = Bundle()
        bundle.putString("nickname",text)
        val bundle2 = Bundle()
        bundle2.putInt("character",characterChosen)
        SettingFragment().arguments = bundle

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        val navController =
            supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            bottomNavigationView.setupWithNavController(it)
        }
    }
}