package com.codesquard.kotlincardgame

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputLayout.*
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {
    private lateinit var nextActivityBtn: Button
    private lateinit var nicknameText: TextInputEditText
    private lateinit var firstBtn: ImageButton
    private lateinit var secondBtn: ImageButton
    private lateinit var thirdBtn: ImageButton
    private lateinit var fourthBtn: ImageButton
    private lateinit var characterImage: ImageView
    private lateinit var selectedBtn: ImageButton
    private var isBtnSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nextActivityBtn = findViewById(R.id.btn_nextActivity)
        nicknameText = findViewById(R.id.nickname_text)
        firstBtn = findViewById(R.id.first_btn)
        secondBtn = findViewById(R.id.second_btn)
        thirdBtn = findViewById(R.id.third_btn)
        fourthBtn = findViewById(R.id.fourth_btn)
        characterImage = findViewById(R.id.character_image)
        setNicknameEditTextLayout()
        setNicknameEditText()
        checkNicknameText()
        clickBtnToShowImage(firstBtn)
        clickBtnToShowImage(secondBtn)
        clickBtnToShowImage(thirdBtn)
        clickBtnToShowImage(fourthBtn)
        clickBtnToMoveCharActivity()
    }

    private fun bitmapToByteArray(imageOfBtn: Drawable): ByteArray {
        val image = imageOfBtn.toBitmap()
        val stream = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }

    private fun clickBtnToMoveCharActivity() {
        nextActivityBtn.setOnClickListener {
            if (isBtnSelected) {
                val intent = Intent(this, CharacterActivity::class.java).apply {
                    putExtra("character", bitmapToByteArray(selectedBtn.drawable))
                    putExtra("nickname", nicknameText.text.toString())
                }
                startActivity(intent)
            } else {
                Snackbar.make(it, "캐릭터를 선택하세요", LENGTH_SHORT).show()
            }
        }
    }

    private fun setupBtnNotSelected() {
        firstBtn.isSelected = false
        secondBtn.isSelected = false
        thirdBtn.isSelected = false
        fourthBtn.isSelected = false
    }

    private fun clickBtnToShowImage(button: ImageButton) {
        button.setOnClickListener {
            setupBtnNotSelected()
            characterImage.setImageDrawable(button.drawable)
            button.isSelected = true
            isBtnSelected = true
            selectedBtn = button
        }
    }

    private fun checkNicknameText() {
        nicknameText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if ((p0?.length ?: 0) == 0) nextActivityBtn.isEnabled = false
            }

            override fun afterTextChanged(p0: Editable?) {
                nextActivityBtn.isEnabled = true
                if ((p0?.contains("[a-zA-Z]".toRegex())) == false || (p0?.contains("[^A-Za-z0-9]".toRegex()) == true))
                    nextActivityBtn.isEnabled = false
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