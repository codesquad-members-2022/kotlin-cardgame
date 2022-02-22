package com.example.cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardgame.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setText(intent.getStringExtra("nickname"))
        when (intent.getIntExtra("character",0)){
            1->binding.imageView.setImageResource(R.drawable.ic_baseline_emoji_emotions_24)
            2-> binding.imageView.setImageResource(R.drawable.ic_baseline_face_24)
            3-> binding.imageView.setImageResource(R.drawable.ic_baseline_mood_bad_24)
            else ->  binding.imageView.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
        }
    }
}