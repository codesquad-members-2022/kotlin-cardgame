package com.codesquad_Han.kotlin_cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.codesquad_Han.kotlin_cardgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun selectCharacter(view: View) {
        if (view is ImageView) {
            binding.ivCharacterSelected.setImageDrawable(view.drawable)
        }
    }
}