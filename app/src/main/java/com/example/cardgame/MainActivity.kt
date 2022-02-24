package com.example.cardgame

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cardgame.databinding.ActivityMainBinding
import java.util.regex.Pattern

const val NONE = 0
const val CHARACTER1 = 1
const val CHARACTER2 = 2
const val CHARACTER3 = 3
const val CHARACTER4 = 4

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var characterChosen = NONE

        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                binding.btnNext.isEnabled =
                    validation(editable.toString())
                            && characterChosen != 0
            }
        })

        binding.imageButton1.setOnClickListener {
            binding.mainImage.setImageResource(R.drawable.ic_baseline_emoji_emotions_24)
            characterChosen = CHARACTER1
        }

        binding.imageButton2.setOnClickListener {
            binding.mainImage.setImageResource(R.drawable.ic_baseline_face_24)
            characterChosen = CHARACTER2
        }

        binding.imageButton3.setOnClickListener {
            binding.mainImage.setImageResource(R.drawable.ic_baseline_mood_bad_24)
            characterChosen = CHARACTER3
        }

        binding.imageButton4.setOnClickListener {
            binding.mainImage.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
            characterChosen = CHARACTER4
        }

        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        binding.btnNext.setOnClickListener {
            intent.putExtra("nickname", binding.editTextTextPersonName.text.toString())
            intent.putExtra("character", characterChosen)
            startActivity(intent)
        }
    }


    private fun validation(nickname: String): Boolean {
        val pattern1 = Pattern.compile("^[a-zA-Z0-9]*\$")
        val pattern2 = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]")

        return (pattern1.matcher(nickname).find() && !(pattern2.matcher(nickname).find()) &&
                nickname.isNotBlank() && nickname.length <= 5)
    }
}