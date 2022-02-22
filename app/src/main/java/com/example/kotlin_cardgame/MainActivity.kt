package com.example.kotlin_cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.kotlin_cardgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var prevSelectBtn: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with (binding) {
            btnCharacter1.setOnClickListener(clickCharacterButtonListener)
            btnCharacter2.setOnClickListener(clickCharacterButtonListener)
            btnCharacter3.setOnClickListener(clickCharacterButtonListener)
            btnCharacter4.setOnClickListener(clickCharacterButtonListener)
        }
    }

    private val clickCharacterButtonListener = View.OnClickListener {
        (it as? ImageButton)?.apply {
            prevSelectBtn?.apply { this.setBackgroundResource(R.color.character_btn_normal_bg) }
            prevSelectBtn = this
            binding.ivSelectCharacter.setImageDrawable(this.drawable)
            this.setBackgroundResource(R.color.character_btn_select_bg)
        }
    }
}