package com.example.kotlincardgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlincardgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view.rootView)
        
    }

}