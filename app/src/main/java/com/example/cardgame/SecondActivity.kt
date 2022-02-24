package com.example.cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cardgame.databinding.SecondActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val text = intent.getStringExtra("nickname")
        val characterChosen = intent.getIntExtra("character", 0)
        val bundle = bundleOf("nickname" to text, "character" to characterChosen)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        val navController =
            supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            bottomNavigationView.setupWithNavController(it)
            it.setGraph(R.navigation.main_navigation, bundle)
        }
    }
}