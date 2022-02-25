package com.example.kotlin_cardgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin_cardgame.databinding.ActivitySubBinding
import com.example.kotlin_cardgame.fragment.GameFragment
import com.example.kotlin_cardgame.fragment.SettingFragment

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding
    private lateinit var gameFragment: Fragment
    private lateinit var settingFragment: Fragment
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameFragment = GameFragment()
        settingFragment = SettingFragment(intent)

        binding.bottomNavigation.setOnItemSelectedListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val tmpFragment: Fragment = when (it.itemId) {
                R.id.page_game -> gameFragment
                else -> settingFragment
            }

            fragmentTransaction.replace(
                R.id.fragment_container_view_tag,
                tmpFragment
            ).commit()
            return@setOnItemSelectedListener true
        }
    }
}