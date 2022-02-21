package com.codesquad.kotlincardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nickname = findViewById<EditText>(R.id.et_nickname)
        val button = findViewById<Button>(R.id.btn_next)
        editTextValidation(nickname, button)
    }

    private fun editTextValidation(nickname: EditText, button: Button) {
        nickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(editable: Editable?) {
                button.isEnabled = isValidation(editable.toString())
            }
        })
    }

    private fun isValidation(nickname: String): Boolean {
        return (nickname.isNotBlank() && nickname.length <= 5 &&
                !isSpecial(nickname) && numbersAndAlphabetOneMoreThan(nickname))
    }

    private fun numbersAndAlphabetOneMoreThan(nickname: String): Boolean {
        val pattern = Pattern.compile("[a-zA-Z]+[0-9]+")
        return pattern.matcher(nickname).find()
    }

    private fun isSpecial(nickname: String): Boolean {
        val pattern = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]")
        return pattern.matcher(nickname).find()
    }
}