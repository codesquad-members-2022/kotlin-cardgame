package com.codesquad.kotilin_cardgame

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val nickname= intent.getStringExtra("nickname")
        val profileImage = intent.getByteArrayExtra("profileImage")!!.let{
            BitmapFactory.decodeByteArray(it,0,it.size)
        }


    }
}