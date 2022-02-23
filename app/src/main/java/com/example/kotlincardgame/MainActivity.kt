package com.example.kotlincardgame

import android.os.Bundle
import android.text.InputFilter
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
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
            stimulateNextButton()
            checkNickname()
        }
        binding.btnNext.setOnClickListener(this)
        setFragment(GameFragment())
        setFragment(OptionFragment())
        binding.bottomNavigation.menu.forEach { it.isEnabled = false }
        selectBottomNavigation()
    }

    override fun onClick(view: View) = when (view.id) {
        R.id.ib_character_1 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_puka)
            stimulateNextButton()
        }
        R.id.ib_character_2 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_lion)
            stimulateNextButton()
        }
        R.id.ib_character_3 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_jeju)
            stimulateNextButton()
        }
        R.id.ib_character_4 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_eb13)
            stimulateNextButton()
        }
        else -> {
            val fragment = GameFragment()
            supportActionBar?.title = "캐릭터 선택"
            replaceFragment(fragment)
            binding.btnNext.visibility = View.GONE
            binding.bottomNavigation.menu.forEach { it.isEnabled = true }
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

    private fun checkCharacter() =
        binding.ivCharacterInfo.drawable != null

    private fun stimulateNextButton() {
        if (checkCharacter() && binding.editText.text.toString() != "") {
            binding.btnNext.isEnabled = true
            return
        }
        binding.btnNext.isEnabled = false
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.view, fragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.view, fragment).commit()
    }

    private fun selectBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.option -> {
                    val fragment = OptionFragment()
                    supportActionBar?.title = "게임 설정"
                    replaceFragment(fragment)
                }
                else -> {
                    val fragment = GameFragment()
                    supportActionBar?.title = "캐릭터 선택"
                    replaceFragment(fragment)
                }
            }
            true
        }
    }

}