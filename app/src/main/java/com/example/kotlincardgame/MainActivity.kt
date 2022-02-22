package com.example.kotlincardgame

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlincardgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view.rootView)
        binding.btnNext.isEnabled = false
        binding.ibCharacter1.setOnClickListener(this)
        binding.ibCharacter2.setOnClickListener(this)
        binding.ibCharacter3.setOnClickListener(this)
        binding.ibCharacter4.setOnClickListener(this)
    }

    override fun onClick(view: View) = when (view.id) {
        R.id.ib_character_1 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_puka)
        }
        R.id.ib_character_2 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_lion)
        }
        R.id.ib_character_3 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_jeju)
        }
        else -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_eb13)
        }
         
    }
}