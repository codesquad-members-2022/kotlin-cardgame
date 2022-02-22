package com.codesquad.kotlincardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        val gameFragment = GameFragment()
        val settingFragment = SettingFragment()

        val bundle = Bundle()
        bundle.putByteArray("image", intent.getByteArrayExtra("image"))
        bundle.putString("nickname", intent.getStringExtra("nickname"))
        settingFragment.arguments = bundle

        bottomNavigationView.setOnItemSelectedListener { item ->
            changeFragment(item.itemId, gameFragment, settingFragment)
            true
        }
    }

    private fun changeFragment(
        itemId: Int,
        gameFragment: GameFragment,
        settingFragment: SettingFragment
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        when (itemId) {
            R.id.navigation_game -> {
                transaction.replace(R.id.container_main, gameFragment).commit()
            }
            R.id.navigation_setting -> {
                transaction.replace(R.id.container_main, settingFragment).commit()
            }
        }
    }
}