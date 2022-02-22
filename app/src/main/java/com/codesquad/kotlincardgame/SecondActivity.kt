package com.codesquad.kotlincardgame

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nickName = findViewById<TextView>(R.id.tv_nickname)
        val imageView = findViewById<ImageView>(R.id.iv_emoji)
        val button = findViewById<Button>(R.id.btn_help)

        val nickname = intent.getStringExtra("nickname")
        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = byteArray?.let { BitmapFactory.decodeByteArray(byteArray, 0, it.size) }

        nickName.text = nickname
        imageView.setImageBitmap(bitmap)
        button.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://codesquad.kr/")))
        }
    }
}