package com.example.kotlin_cardgame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_cardgame.data.UserInfo
import com.example.kotlin_cardgame.databinding.ActivityMainBinding
import com.example.kotlin_cardgame.util.ImageUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var bSelected: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAllCharacterButtonListener()
        binding.editNickname.addTextChangedListener(verifyInputValue)

        val intent = Intent(this, SubActivity::class.java)
        binding.btnNext.setOnClickListener {
            if (!bSelected) {
                Toast.makeText(this, "캐릭터를 선택해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            intent.putExtra("userInfo", UserInfo(
                ImageUtil.convertDrawableToByteArray(binding.ivSelectCharacter.drawable),
                binding.editNickname.text.toString())
            )
            startActivity(intent)
        }
    }

    private fun setAllCharacterButtonListener() {
        with(binding) {
            btnCharacter1.setOnClickListener {
                setAllCharacterButtonUnselect()
                ivSelectCharacter.setImageDrawable(btnCharacter1.drawable)
                btnCharacter1.setBackgroundResource(R.color.character_btn_select_bg)
                bSelected = true
            }

            btnCharacter2.setOnClickListener {
                setAllCharacterButtonUnselect()
                ivSelectCharacter.setImageDrawable(btnCharacter2.drawable)
                btnCharacter2.setBackgroundResource(R.color.character_btn_select_bg)
                bSelected = true
            }

            btnCharacter3.setOnClickListener {
                setAllCharacterButtonUnselect()
                ivSelectCharacter.setImageDrawable(btnCharacter3.drawable)
                btnCharacter3.setBackgroundResource(R.color.character_btn_select_bg)
                bSelected = true
            }

            btnCharacter4.setOnClickListener {
                setAllCharacterButtonUnselect()
                ivSelectCharacter.setImageDrawable(btnCharacter4.drawable)
                btnCharacter4.setBackgroundResource(R.color.character_btn_select_bg)
                bSelected = true
            }
        }
    }

    private fun setAllCharacterButtonUnselect() {
        with(binding) {
            btnCharacter1.setBackgroundResource(R.color.character_btn_normal_bg)
            btnCharacter2.setBackgroundResource(R.color.character_btn_normal_bg)
            btnCharacter3.setBackgroundResource(R.color.character_btn_normal_bg)
            btnCharacter4.setBackgroundResource(R.color.character_btn_normal_bg)
        }
    }

    private val verifyInputValue = object: TextWatcher {
        override fun beforeTextChanged(str: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(str: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(str: Editable?) = with(binding) {
            if (str.toString().matches(Regex("^(?!(?:[0-9]+)\$)([a-zA-Z]|[0-9a-zA-Z])+\$"))) {
                tvInputVerify.setTextColor(Color.BLUE)
                tvInputVerify.text = "사용가능한 닉네임입니다."
                btnNext.isEnabled = true
            } else {
                tvInputVerify.setTextColor(Color.RED)
                tvInputVerify.text = "알파벳이 1개 이상 포함되어야 합니다. (공백, 특수문자 제외)"
                btnNext.isEnabled = false
            }
        }
    }
}