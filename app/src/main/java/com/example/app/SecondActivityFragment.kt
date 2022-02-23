package com.example.app

import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.lang.reflect.Array.newInstance

class SecondActivityFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val gameID = findViewById<TextView>(R.id.show_id_text)
        val characterImage = findViewById<ImageView>(R.id.character_selected_image)

        val userData = intent.getSerializableExtra("Data")

        val navigation =
            findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.navigation_main)

        navigation.setOnItemSelectedListener {
            changeFragment(it.itemId)
            true
        }

        changeFragment(R.id.navigation_main)
    }

    private fun changeFragment(menuItemId: Int) {
        val targetFragment = getFragment(menuItemId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_main, targetFragment)
            .commitAllowingStateLoss()
    }

    private fun getFragment(menuItemId: Int): Fragment {
        val title = when (menuItemId) {
            R.id.navigation_main -> GameFragment()
            R.id.navigation_setting -> SettingFragment()
            else -> throw IllegalArgumentException("not found menu item id")
        }
        return title
    }
}