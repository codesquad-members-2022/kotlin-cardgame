package com.codesquad.kotlincardgame

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.core.graphics.drawable.toBitmap
import java.io.ByteArrayOutputStream
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nickname = findViewById<EditText>(R.id.et_nickname)
        val button = findViewById<Button>(R.id.btn_next)
        val radioGroup = findViewById<RadioGroup>(R.id.radiogroup_emoji)
        val imageView = findViewById<ImageView>(R.id.iv_main_emoji)

        editTextEvent(nickname, button, radioGroup)
        radioButtonEvent(radioGroup, imageView, nickname, button)
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        button.setOnClickListener {
            intent.putExtra("nickname", nickname.text.toString())
            val bitmap = imageView.drawable.toBitmap()
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val byteArray = stream.toByteArray()
            intent.putExtra("image", byteArray)
            startActivity(intent)
        }
    }

    private fun radioButtonEvent(
        radioGroup: RadioGroup,
        imageView: ImageView,
        nickname: EditText,
        button: Button
    ) {
        radioGroup.setOnCheckedChangeListener { _, checkId ->
            when (checkId) {
                R.id.radiobutton_emoji1 -> {
                    imageView.setImageResource(R.drawable.ic_happy_emoji_svgrepo_com)
                    if(isValidation(nickname.text.toString()))
                        button.isEnabled = true
                }
                R.id.radiobutton_emoji2 -> {
                    imageView.setImageResource(R.drawable.ic_happy_emoji_svgrepo_com__1_)
                    if(isValidation(nickname.text.toString()))
                        button.isEnabled = true
                }
                R.id.radiobutton_emoji3 -> {
                    imageView.setImageResource(R.drawable.ic_shocked_emoji_svgrepo_com)
                    if(isValidation(nickname.text.toString()))
                        button.isEnabled = true
                }
                R.id.radiobutton_emoji4 -> {
                    imageView.setImageResource(R.drawable.ic_surprised_emoji_svgrepo_com)
                    if(isValidation(nickname.text.toString()))
                        button.isEnabled = true
                }
            }
        }
    }

    private fun editTextEvent(nickname: EditText, button: Button, radioGroup: RadioGroup) {
        nickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(editable: Editable?) {
                button.isEnabled = isValidation(editable.toString()) && radioGroup.checkedRadioButtonId != -1
            }
        })
    }

    private fun isValidation(nickname: String): Boolean {
        return (nickname.isNotBlank() && nickname.length <= 5 &&
                !isSpecial(nickname) && numbersAndAlphabetOneMoreThan(nickname))
    }

    private fun numbersAndAlphabetOneMoreThan(nickname: String): Boolean {
        val pattern = Pattern.compile("^[0-9]*[a-zA-Z]+[0-9]*\$")
        return pattern.matcher(nickname).find()
    }

    private fun isSpecial(nickname: String): Boolean {
        val pattern = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]")
        return pattern.matcher(nickname).find()
    }
}