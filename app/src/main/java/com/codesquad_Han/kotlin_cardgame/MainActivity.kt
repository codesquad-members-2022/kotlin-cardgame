package com.codesquad_Han.kotlin_cardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.codesquad_Han.kotlin_cardgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val characterArray = arrayOfNulls<Pair<View, Boolean>>(4)

    private var isAlphabetIncluded = false
    private var isSpeciaCharactersNotIncluded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCharacterArray()
        setCharacterClickListener()
        setEditText()

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
                if(!characterArray[i]!!.second) { // 선택이 되지 않은 캐릭터를 선택하는 경우
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

    fun setEditText(){
        binding.etNickName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                checkNickName(s)
            }
        })
    }

    fun checkNickName(s: Editable?){
        isAlphabetIncluded = false
        isSpeciaCharactersNotIncluded = true
        var nickname = s.toString()
        for(i in 0..nickname.length-1){
            if(nickname[i] in 'a'..'z' || nickname[i] in 'A'..'Z'){
                isAlphabetIncluded = true
            }
            if(!((nickname[i] in '0'..'9')||(nickname[i] in 'a'..'z')||(nickname[i] in 'A'..'Z'))){
                isSpeciaCharactersNotIncluded = false
                break
            }
        }
        checkBtn()
    }

    fun checkBtn(){
        binding.btnNext.isEnabled = isAlphabetIncluded && isSpeciaCharactersNotIncluded
    }
}