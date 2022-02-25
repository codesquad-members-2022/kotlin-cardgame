package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class SecondActivityFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

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
        val userData = intent.getSerializableExtra("Data") as User
        val bundle = Bundle()
        bundle.putSerializable("user", userData)
        targetFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_main, targetFragment)
            .commit()
    }

    private fun getFragment(menuItemId: Int): Fragment {
        val title = when (menuItemId) {
            R.id.navigation_main -> SettingFragment()
            R.id.navigation_setting -> GameFragment()
            else -> throw IllegalArgumentException("not found menu item id")
        }
        return title
    }
}