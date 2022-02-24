package com.example.kotlin_cardgame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.example.kotlin_cardgame.data.UserInfo
import com.example.kotlin_cardgame.databinding.ActivityMainBinding
import com.example.kotlin_cardgame.util.ImageUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var curSelectBtn: ImageButton? = null
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

        val intent = Intent(this, SubActivity::class.java)
        binding.btnNext.setOnClickListener {
            if (curSelectBtn == null) {
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

    private val verifyInputValue = object: TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
        override fun afterTextChanged(p0: Editable?) = with(binding) {
            if (p0.toString().matches(Regex("^(?!(?:[0-9]+)\$)([a-zA-Z]|[0-9a-zA-Z])+\$"))) {
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

    private val clickCharacterButtonListener = View.OnClickListener {
        (it as? ImageButton)?.apply {
            curSelectBtn?.apply { this.setBackgroundResource(R.color.character_btn_normal_bg) }
            curSelectBtn = this
            binding.ivSelectCharacter.setImageDrawable(this.drawable)
            this.setBackgroundResource(R.color.character_btn_select_bg)
        }
    }
}