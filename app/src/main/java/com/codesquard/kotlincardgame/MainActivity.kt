package com.codesquard.kotlincardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputLayout.*
import java.util.*
import java.util.regex.Pattern
import kotlin.math.E

class MainActivity : AppCompatActivity() {
    private lateinit var nextActivityBtn: Button
    private lateinit var nicknameText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nextActivityBtn = findViewById(R.id.btn_nextActivity)
        nicknameText = findViewById(R.id.nickname_text)
        setNicknameEditTextLayout()
        setNicknameEditText()
        checkNicknameText()
    }

    private fun checkNicknameText() {
        nicknameText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.filter {
                    nextActivityBtn.isEnabled = true
                    if (!(p0.contains("[A-Z|a-z]".toRegex()))) nextActivityBtn.isEnabled = false
                    !(it.isLetterOrDigit())
                }?.forEach {
                    nextActivityBtn.isEnabled = false
                } ?: throw IllegalArgumentException("잘못된 값입니다")
            }
        })
    }

    private fun setNicknameEditTextLayout() {
        val nicknameTextLayout: TextInputLayout = findViewById(R.id.nickname_text_layout)
        nicknameTextLayout.endIconMode = END_ICON_CLEAR_TEXT
        nicknameTextLayout.helperText = "최대 5글자, 공백/특수문자 제외, 최소 1글자는 알파벳 포함"
        nicknameTextLayout.isCounterEnabled = true
        nicknameTextLayout.counterMaxLength = 5
        nicknameTextLayout.hint = "닉네임"
    }

    private fun setNicknameEditText() {
        val nicknameText: TextInputEditText = findViewById(R.id.nickname_text)
        nicknameText.filters = arrayOf(InputFilter.LengthFilter(5))
        nicknameText.setSingleLine()
    }

}