package com.example.cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.cardgame.GameFragment.Companion.TAG
import com.example.cardgame.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editText.isEnabled = false

        binding.editText.addTextChangedListener {
            val str = binding.editText.text.toString()

            binding.button.isEnabled = Langtype().english(str)

            binding.editText.filters = arrayOf(
                InputFilter { source, _, _, _, _, _ ->
                    val ps: Pattern =
                        Pattern.compile("^[a-zA-Z0-9\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$")

                    if (source == "" || ps.matcher(source).matches()) {
                        return@InputFilter source
                    }
                    Toast.makeText(this, "영문, 숫자만 입력 가능합니다.", Toast.LENGTH_SHORT).show()
                    ""
                },
            )
        }

        binding.imageButton.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
            binding.editText.isEnabled = true
        }

        binding.imageButton2.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.ic_baseline_emoji_emotions_24)
            binding.editText.isEnabled = true
        }

        binding.imageButton3.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.ic_baseline_add_reaction_24)
            binding.editText.isEnabled = true
        }

        binding.imageButton4.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.ic_baseline_sick_24)
            binding.editText.isEnabled = true
        }

        binding.bottomNav.setOnNavigationItemSelectedListener(onBottomNaItemSelectedListener)
    }
}

private val onBottomNaItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
    when (it.itemId) {
        R.id.menu_game -> {
            Log.d(TAG, "MainActivity - 게임버튼 클릭")
        }
        R.id.menu_setting -> {
            Log.d(TAG, "MainActivity - 설정버튼 클릭")
        }
    }
    true
}

class Langtype {
    fun english(s: String): Boolean {
        var i = 0
        while (i < s.length) {
            val c = s.codePointAt(i)
            if (c in 0x0041..0x007A)
                return true
            i += Character.charCount(c)
        }
        return false
    }
}