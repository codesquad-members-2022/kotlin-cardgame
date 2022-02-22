package com.codesquad.kotilin_cardgame

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.io.ByteArrayOutputStream
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    var nicknameSelectedFlag = false
    var profileImageSelectedFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editNickNameLayout = findViewById<TextInputLayout>(R.id.textinput_nickname)
        val editNickName = editNickNameLayout.editText!!
        val moveBtn = findViewById<Button>(R.id.btn_move_card)
        val radioGroup = findViewById<RadioGroup>(R.id.radiogroup_emoji)
        val selectedImage = findViewById<ImageView>(R.id.iv_profile_card)
        addTextFilter(editNickNameLayout)
        addTextWatcher(editNickName, editNickNameLayout, moveBtn)
        addRadioEvent(radioGroup, selectedImage, moveBtn)
        val intent = Intent(this, SubActivity::class.java)
        moveBtn.setOnClickListener {
            intent.putExtra("nickname", editNickName.text.toString())
            val bitmap = selectedImage.drawable.toBitmap()
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            intent.putExtra("profileImage", stream.toByteArray())
            startActivity(intent)
        }
    }

    fun addRadioEvent(
        radioGroup: RadioGroup,
        selectedImageView: ImageView,
        moveBtn: Button
    ) {
        radioGroup.setOnCheckedChangeListener { _, checkId ->
            when (checkId) {
                R.id.rbtn_bigsmile_card -> {
                    selectedImageView.setImageResource(R.drawable.profile_bighappy)
                    profileImageSelectedFlag = true
                    if (nicknameSelectedFlag) moveBtn.isEnabled = true
                }
                R.id.rbtn_smile_card -> {
                    selectedImageView.setImageResource(R.drawable.profile_happy)
                    profileImageSelectedFlag = true
                    if (nicknameSelectedFlag) moveBtn.isEnabled = true
                }
                R.id.rbtn_sad_card -> {
                    selectedImageView.setImageResource(R.drawable.profile_sad)
                    profileImageSelectedFlag = true
                    if (nicknameSelectedFlag) moveBtn.isEnabled = true
                }
                R.id.rbtn_bigsad_card -> {
                    selectedImageView.setImageResource(R.drawable.profile_bigsad)
                    profileImageSelectedFlag = true
                    if (nicknameSelectedFlag) moveBtn.isEnabled = true
                }

            }
        }
    }

    fun addTextFilter(editNickNameLayout: TextInputLayout) {
        val editNickName = editNickNameLayout.editText!!
        editNickName.filters = arrayOf(
            InputFilter { src, start, end, dst, dstart, dend ->
                if (src.matches(Regex("^[a-zA-Z0-9]+$"))) {
                    editNickNameLayout.error = null
                    return@InputFilter src
                }
                //backspace 입력시 처리
                if (src == "") {
                    editNickNameLayout.error = null
                    return@InputFilter src
                }
                editNickNameLayout.error = "영어와 숫자만 입력해주세요"
                return@InputFilter ""
            }, InputFilter.LengthFilter(5)
        )
    }

    fun checkOnlyNumberType(
        editNickName: EditText,
        editNickNameLayout: TextInputLayout,
        link: Button
    ) {
        val nickname = editNickName.text
        val includeAlphaBet = Pattern.compile(".*[a-zA].*")
        if (includeAlphaBet.matcher(nickname).matches()) {
            editNickNameLayout.error = null
            Snackbar.make(editNickName, "닉네임 입력 확인되었습니다", Snackbar.LENGTH_SHORT).show()
            nicknameSelectedFlag = true
            if (profileImageSelectedFlag) {
                link.isEnabled = true
            }

        } else {
            editNickNameLayout.error = "알파벳이 하나라도 포함되도록 다시입력해주세요"
            link.isEnabled = false
        }
    }

    fun addTextWatcher(editNickName: EditText, editNickNameLayout: TextInputLayout, link: Button) {
        editNickName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if (editNickName.text.isEmpty()) {
                    editNickNameLayout.error = "한글자 이상 입력하세요"
                    link.isEnabled = false
                } else {
                    editNickNameLayout.error = null
                    checkOnlyNumberType(editNickName, editNickNameLayout, link)
                }
            }
        }
        )
    }

}

