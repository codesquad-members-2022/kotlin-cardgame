package com.example.kotlincardgame

import android.os.Bundle
import android.text.InputFilter
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.kotlincardgame.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view.rootView)
        binding.btnNext.isEnabled = false
        binding.ibCharacter1.setOnClickListener(this)
        binding.ibCharacter2.setOnClickListener(this)
        binding.ibCharacter3.setOnClickListener(this)
        binding.ibCharacter4.setOnClickListener(this)
        binding.editText.doAfterTextChanged {
            vitalizeNextButton()
            checkNickname()
        }
        binding.btnNext.setOnClickListener(this)
        binding.bottomNavigation
    }

    override fun onClick(view: View) = when (view.id) {
        R.id.ib_character_1 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_puka)
            vitalizeNextButton()
        }
        R.id.ib_character_2 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_lion)
            vitalizeNextButton()
        }
        R.id.ib_character_3 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_jeju)
            vitalizeNextButton()
        }
        R.id.ib_character_4 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_eb13)
            vitalizeNextButton()
        }
        else -> {
            val gameFragment = GameFragment()
            supportActionBar?.title = "게임 설정"
            replaceFragment(gameFragment)
        }

    }

    private fun checkNickname() {
        binding.editText.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val ps: Pattern =
                Pattern.compile("^[a-zA-Z0-9\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$")
            if (source.count() > 5) {
                binding.editText.error = "5글자 이하만 입력 가능합니다."
            }
            if (source == "" || ps.matcher(source).matches()) {
                return@InputFilter source
            }
            binding.editText.error = "영문, 숫자만 입력 가능합니다.(5글자 이하)"
            ""
        }, InputFilter.LengthFilter(5))
    }

    private fun checkChooseCharacter() = binding.ivCharacterInfo.drawable != null
    private fun vitalizeNextButton(){
        if(checkChooseCharacter() && binding.editText.text.toString() != ""){
            binding.btnNext.isEnabled = true
            return
        }
        binding.btnNext.isEnabled = false
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.view, fragment)
        fragmentTransaction.commit()
    }
}