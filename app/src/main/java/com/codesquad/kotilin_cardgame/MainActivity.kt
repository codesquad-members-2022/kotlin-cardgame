package com.codesquad.kotilin_cardgame

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern
import android.text.TextWatcher as TextWatcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editNickName = findViewById<EditText>(R.id.et_cadrgame_nickname)

        val outerLayout = findViewById<LinearLayout>(R.id.linearly_out_card)
        editNickName.setOnKeyListener { v, keyCode, event ->
            var handled = false

            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KEYCODE_ENTER) {
                val nickname = editNickName.text.trim()
                when {
                    nickname.length > 5 || nickname.isEmpty() -> {
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
                        handled = true
                    }
                    else -> {
                        val ps: Pattern =
                            Pattern.compile("^[a-zA-Z0-9\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$")
                        if (ps.matcher(nickname).matches()) {

                            val incluedeAlphaBet= Pattern.compile(".*[a-zA].*")
                            if(incluedeAlphaBet.matcher(nickname).matches()){
                                Toast.makeText(
                                    this@MainActivity,
                                    "닉네임 입력 확인되었습니다",
                                    Toast.LENGTH_SHORT
                                ).show()
                                handled = true
                                outerLayout.requestFocus()
                            }
                            else{
                                Toast.makeText(
                                    this@MainActivity,
                                    "알파벳이 하나라도 포함되도록 다시입력해주세요",
                                    Toast.LENGTH_SHORT
                                ).show()
                                editNickName.setText("")
                            }

                        } else {
                            Toast.makeText(this, "영문, 숫자만 입력 가능합니다.", Toast.LENGTH_SHORT).show()
                            editNickName.setText("")
                        }
                    }
                }
            }
            handled
        }


    }


}