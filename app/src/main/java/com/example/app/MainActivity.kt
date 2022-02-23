package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import java.util.regex.Pattern
import java.io.Serializable


data class User(
    val username: String, val Int: Int
) : Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextButton = findViewById<EditText>(R.id.character_name_input_button)
        val hintText = findViewById<TextView>(R.id.input_text_hint)
        val button1 = findViewById<ImageButton>(R.id.character_button1)
        val button2 = findViewById<ImageButton>(R.id.character_button2)
        val button3 = findViewById<ImageButton>(R.id.character_button3)
        val button4 = findViewById<ImageButton>(R.id.character_button4)
        val nextButton = findViewById<Button>(R.id.next_button)
        val image = findViewById<ImageView>(R.id.character_image_show)
        var inputString: String = ""


        editTextButton.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val idValidation = Regex("^[a-zA-Z0-9]+\$").toString()
                inputString = editTextButton.text.toString().trim()
                val isCheckedString = Pattern.matches(idValidation, inputString)

                if (isCheckedString) {
                    hintText.text = "사용가능한 ID입니다"
                    nextButton.isEnabled = true
                    nextButton.setBackgroundColor(R.color.purple_200.toInt())
                } else {
                    hintText.text = "다시입력해 주세요"
                    hintText.setTextColor(R.color.red.toInt())
                    nextButton.isEnabled = false
                    nextButton.setBackgroundColor(R.color.purple_500.toInt())
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        button1.setOnClickListener {
            image.setImageResource(R.drawable.ic_baseline_outlet_24)
        }

        button2.setOnClickListener {
            image.setImageResource(R.drawable.ic_person)
        }

        button3.setOnClickListener {
            image.setImageResource(R.drawable.ic_mom_and_son)
        }

        button4.setOnClickListener {
            image.setImageResource(R.drawable.ic_mouse)
        }

        nextButton.setOnClickListener {
            val user = User(inputString, R.drawable.ic_baseline_done_24)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Data", user)
            startActivity(intent)
        }

    }
}