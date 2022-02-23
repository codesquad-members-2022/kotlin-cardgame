package com.codesquard.kotlincardgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class CharacterActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    private val charFragment = CharacterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        bottomNav = findViewById(R.id.bottom_navigation)
        controlNavigation()
    }

    private fun controlNavigation() {
        val bundle = transferDataTofragment()
        val navController =
            supportFragmentManager.findFragmentById(R.id.layout_fragment)?.findNavController()
        navController?.let {
            it.setGraph(R.navigation.character_navigation, bundle)
            bottomNav.setupWithNavController(it)
        }
    }

    /*private fun clickBottomNav() {
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_game -> {
                    supportFragmentManager.commit {
                        replace(R.id.layout_fragment, GameFragment())
                        addToBackStack(null)
                    }
                    true
                }
                R.id.navigation_setting -> {
                    transferDataTofragment()
                    supportFragmentManager.commit {
                        replace(R.id.layout_fragment, charFragment)
                        addToBackStack(null)
                    }
                    true
                }
                else -> false
            }
        }
    }*/

    private fun transferDataTofragment(): Bundle {
        val nickname = intent.getStringExtra("nickname")
        val image = intent.getByteArrayExtra("character")
        /*
        bundle.putString("name", nickname)
        bundle.putByteArray("char", image)
        charFragment.arguments = bundle*/
        return bundleOf("name" to nickname, "char" to image)
    }

}