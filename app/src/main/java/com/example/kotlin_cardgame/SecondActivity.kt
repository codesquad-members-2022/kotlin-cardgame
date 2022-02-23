package com.example.kotlin_cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin_cardgame.databinding.ActivitySecondBinding

private const val TAG = "SecondActivity"

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationClickListening()

        val x = intent.getSerializableExtra("Emotion.kt")
        Log.d(TAG, x.toString())
    }


    private fun navigationClickListening() {
        // 최초 프레그먼트 설정
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, GameFragment()).commit()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.page_1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, GameFragment()).commit()
                    binding.fragmentContainer
                    true
                }
                R.id.page_2 -> {
                    val settingFragment = SettingFragment()
                   
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, settingFragment).commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}