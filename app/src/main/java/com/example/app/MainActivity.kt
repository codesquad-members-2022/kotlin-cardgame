package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import com.example.app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout = findViewById<LinearLayout>(R.id.main_layout)
        val editTextButton = findViewById<EditText>(R.id.character_name_input_button)
        val button1 = findViewById<ImageButton>(R.id.character_button1)
        val button2 = findViewById<ImageButton>(R.id.character_button2)
        val button3 = findViewById<ImageButton>(R.id.character_button3)
        val button4 = findViewById<ImageButton>(R.id.character_button4)


    }

    override fun onStart() {
        super.onStart()


    }
}