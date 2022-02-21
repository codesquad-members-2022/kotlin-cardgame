package com.codesquad.kotilin_cardgame

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    var nicknameSelectedFlag = false
    var profileImageSelectedFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editNickName = findViewById<EditText>(R.id.et_cadrgame_nickname)
        val moveBtn = findViewById<Button>(R.id.btn_move_card)
        val buttonBigSmile = findViewById<ImageButton>(R.id.imgbtn_bigsmile_card)
        val buttonSmile = findViewById<ImageButton>(R.id.imgbtn_smile_card)
        val buttonSad = findViewById<ImageButton>(R.id.imgbtn_sad_card)
        val buttonBigSad = findViewById<ImageButton>(R.id.imgbtn_bigsad_card)
        val selectedImage = findViewById<ImageView>(R.id.iv_profile_card)
        addTextFilter(editNickName)
        addNicknameVerification(editNickName,moveBtn)
        addImageButtonListener(buttonBigSmile, selectedImage, moveBtn)
        addImageButtonListener(buttonSmile, selectedImage,moveBtn)
        addImageButtonListener(buttonSad, selectedImage,moveBtn)
        addImageButtonListener(buttonBigSad, selectedImage,moveBtn)
        addLinkToSub(moveBtn)

    }

    fun addLinkToSub(moveBtn: Button) {
        moveBtn.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }

    fun addImageButtonListener(button: ImageButton, selected: ImageView, link: Button) {
        button.setOnClickListener {
            when (it.id) {
                R.id.imgbtn_bigsmile_card -> {
                    profileImageSelectedFlag = true
                    if(nicknameSelectedFlag) link.isEnabled= true
                    selected.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_sentiment_very_satisfied_55, null))
                }
                R.id.imgbtn_smile_card -> {
                    profileImageSelectedFlag = true
                    if(nicknameSelectedFlag) link.isEnabled= true
                    selected.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_sentiment_satisfied_55, null)
                    )
                }
                R.id.imgbtn_sad_card -> {
                    profileImageSelectedFlag = true
                    if(nicknameSelectedFlag) link.isEnabled= true
                    selected.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_sentiment_dissatisfied_55, null))
                }
                R.id.imgbtn_bigsad_card -> {
                    profileImageSelectedFlag = true
                    if(nicknameSelectedFlag) link.isEnabled= true
                    selected.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_sentiment_very_dissatisfied_24, null))
                }
                else -> selected.setBackgroundColor(Color.WHITE)
            }
        }
    }

    fun addTextFilter(editNickName: EditText) {
        editNickName.setFilters(arrayOf(
            InputFilter { src, start, end, dst, dstart, dend ->
                if (src.matches(Regex("^[a-zA-Z0-9]+$"))) {
                    return@InputFilter src
                }
                //backspace 입력시 처리
                if (src == "") {
                    return@InputFilter src
                }
                Toast.makeText(this, "영어 숫자만 입력해주세요", Toast.LENGTH_SHORT).show()
                return@InputFilter ""
            }
        ))
    }

    fun displayNickNameLengthError(editNickName: EditText) {
        AlertDialog.Builder(this@MainActivity)
            .setTitle("닉네임 길이 에러")
            .setMessage("닉네임 길이는 1~5자 사이여야 합니다")
            .setPositiveButton("ok", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    editNickName.setText("")
                    Toast.makeText(
                        this@MainActivity,
                        "닉네임 재입력 해주세여",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
            .show()
    }

    fun checkOnlyNumberType(editNickName: EditText, link: Button) {
        val nickname = editNickName.text
        val includeAlphaBet = Pattern.compile(".*[a-zA].*")
        if (includeAlphaBet.matcher(nickname).matches()) {
            Toast.makeText(
                this@MainActivity,
                "닉네임 입력 확인되었습니다",
                Toast.LENGTH_SHORT
            ).show()
            nicknameSelectedFlag = true
            if(profileImageSelectedFlag) link.isEnabled= true
        } else {
            Toast.makeText(
                this@MainActivity,
                "알파벳이 하나라도 포함되도록 다시입력해주세요",
                Toast.LENGTH_SHORT
            ).show()
            link.isEnabled=false
            editNickName.setText("")
        }
    }

    fun addNicknameVerification(editNickName: EditText , link: Button) {
        editNickName.setOnKeyListener { view, keyCode, event ->
            var handled= false
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KEYCODE_ENTER) {
                val nickname = editNickName.text
                when {
                    nickname.length > 5 || nickname.isEmpty() -> {
                        displayNickNameLengthError(editNickName)
                        link.isEnabled=false
                        handled=true
                    }
                    else -> {
                        checkOnlyNumberType(editNickName,link)
                        handled=true
                    }
                }
            }
            if (event.action == EditorInfo.IME_ACTION_DONE) {
                // 키보드 내리기
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(editNickName.windowToken, 0)
                handled=true
            }
            handled
        }
    }

}