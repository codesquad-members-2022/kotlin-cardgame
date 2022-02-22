package com.example.kotlin_cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_cardgame.data.UserInfo
import com.example.kotlin_cardgame.databinding.ActivitySubBinding
import com.example.kotlin_cardgame.util.ImageUtil

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data: UserInfo = intent.getSerializableExtra("userInfo") as UserInfo
        val drawable = ImageUtil.convertByteArrayToDrawable(data.byteArrayOfImage)
        binding.ivImage.setImageBitmap(drawable)
    }
}