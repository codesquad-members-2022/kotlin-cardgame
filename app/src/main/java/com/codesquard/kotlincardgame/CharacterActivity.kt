package com.codesquard.kotlincardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView


class CharacterActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    val charFragment = CharacterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        bottomNav = findViewById(R.id.bottom_navigation)
        clickBottomNav()
    }

    private fun clickBottomNav() {
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.game -> {
                    supportFragmentManager.commit {
                        replace(R.id.layout_fragment, GameFragment())
                    }
                    true
                }
                R.id.setting -> {
                    transferDataTofragment()
                    supportFragmentManager.commit {
                        replace(R.id.layout_fragment, charFragment)
                    }
                    true
                }
                else -> false
            }
        }
    }

    private fun transferDataTofragment() {
        val nickname = intent.getStringExtra("nickname")!!
        val image = intent.getByteArrayExtra("character")!!
        val bundle = Bundle()
        bundle.putString("name", nickname)
        bundle.putByteArray("char", image)
        charFragment.getTextAndImage(nickname,image)
    }
}