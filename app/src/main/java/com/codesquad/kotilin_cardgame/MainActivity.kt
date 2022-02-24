package com.codesquad.kotilin_cardgame

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.text.Editable
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

    fun checkEmpty(nickName: Editable, editNickNameLayout: TextInputLayout): Boolean {
        return if(nickName.isEmpty()) {
            editNickNameLayout.error = "한글자 이상 입력하세요"
            true
        }
        else {
            false
        }
    }

    fun checkOnlyNumberType(nickName: Editable, editNickNameLayout: TextInputLayout, ): Boolean {
        val pattern = Regex(".*[a-zA].*")
        return if (nickName.matches(pattern)) {
            true
        } else {
            editNickNameLayout.error = "알파벳이 하나라도 포함되야 합니다"
            false
        }
    }

    fun checkSpecial(nickname: Editable, editNickNameLayout: TextInputLayout): Boolean {
        val pattern = Regex("^[a-zA-Z0-9]+$")
        return if (nickname.matches(pattern)) {
            editNickNameLayout.error = null
            true
        } else {
            editNickNameLayout.error = "특수 문자는 허용되지 않습니다"
            false
        }
    }

    fun addTextWatcher(editNickName: EditText, editNickNameLayout: TextInputLayout, link: Button) {
        editNickName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                val nickName = editNickName.text
                if (!checkEmpty(nickName,editNickNameLayout)&&checkSpecial(nickName,editNickNameLayout)&&checkOnlyNumberType(nickName,editNickNameLayout)) {
                    editNickNameLayout.error = null
                    Snackbar.make(editNickNameLayout, "닉네임 입력 확인되었습니다", Snackbar.LENGTH_SHORT).show()
                    nicknameSelectedFlag=true
                    if(profileImageSelectedFlag){
                        link.isEnabled=true
                    }
                }
            }
        }
        )
    }

}

