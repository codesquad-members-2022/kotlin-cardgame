package com.codesquad_Han.kotlin_cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codesquad_Han.kotlin_cardgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}