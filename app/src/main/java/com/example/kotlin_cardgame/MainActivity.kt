package com.example.kotlin_cardgame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.Log
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

        binding.editNickname.addTextChangedListener(verifyInputValue)
    }

    private val verifyInputValue = object: TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
        override fun afterTextChanged(p0: Editable?) {
            if (p0.toString().matches(Regex("^(?!(?:[0-9]+)\$)([a-zA-Z]|[0-9a-zA-Z])+\$"))) {
                binding.tvInputVerify.setTextColor(Color.BLUE)
                binding.tvInputVerify.text = "사용가능한 닉네임입니다."
                binding.btnNext.isEnabled = true
            } else {
                binding.tvInputVerify.setTextColor(Color.RED)
                binding.tvInputVerify.text = "알파벳이 1개 이상 포함되어야 합니다. (공백, 특수문자 제외)"
                binding.btnNext.isEnabled = false
            }
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