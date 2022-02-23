package com.codesquad_Han.kotlin_cardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.codesquad_Han.kotlin_cardgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val characterArray = arrayOfNulls<Pair<View, Boolean>>(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCharacterArray()
        setCharacterClickListener()

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }
    }

    fun setCharacterArray(){
        characterArray[0] = Pair(binding.ivCharacter1, false)
        characterArray[1] = Pair(binding.ivCharacter2, false)
        characterArray[2] = Pair(binding.ivCharacter3, false)
        characterArray[3] = Pair(binding.ivCharacter4, false)
    }

    fun setCharacterClickListener(){
        (0..3).forEach {
            var i = it
            characterArray[i]!!.first.setOnClickListener {
                if(!characterArray[i]!!.second) {
                    changeCharacterBackground(i)
                    binding.ivCharacterSelected.setImageDrawable((characterArray[i]!!.first as ImageView).drawable)
                }
            }
        }
    }

    fun changeCharacterBackground(selected: Int){
        (0..3).forEach {
            characterArray[it]!!.first.setBackgroundColor(ContextCompat.getColor(this, R.color.unselected))
            characterArray[it] = characterArray[it]!!.copy(second = false)
        }
        characterArray[selected]!!.first.setBackgroundColor(ContextCompat.getColor(this, R.color.selected))
        characterArray[selected] = characterArray[selected]!!.copy(second = true)
    }
}