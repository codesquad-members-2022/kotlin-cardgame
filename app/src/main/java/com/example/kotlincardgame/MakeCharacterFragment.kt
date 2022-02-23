package com.example.kotlincardgame

import android.os.Bundle
import android.text.InputFilter
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.forEach
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kotlincardgame.databinding.FragmentMakeCharacterBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.regex.Pattern

class MakeCharacterFragment : BaseFragment<FragmentMakeCharacterBinding>(FragmentMakeCharacterBinding::inflate) , View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.isEnabled = false
        binding.ibCharacter1.setOnClickListener(this)
        binding.ibCharacter2.setOnClickListener(this)
        binding.ibCharacter3.setOnClickListener(this)
        binding.ibCharacter4.setOnClickListener(this)
        binding.editText.doAfterTextChanged {
            checkNickname()
            vitalizeNextButton()
        }
        binding.btnNext.setOnClickListener(this)
    }
    override fun onClick(view: View) = when (view.id) {
        R.id.ib_character_1 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_puka)
            setAttributeDrawable("btn_off_puka")
            vitalizeNextButton()
        }
        R.id.ib_character_2 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_lion)
            setAttributeDrawable("btn_off_lion")
            vitalizeNextButton()
        }
        R.id.ib_character_3 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_jeju)
            setAttributeDrawable("btn_off_jeju")
            vitalizeNextButton()
        }
        R.id.ib_character_4 -> {
            binding.ivCharacterInfo.setImageResource(R.drawable.btn_off_eb13)
            setAttributeDrawable("btn_off_eb13")
            vitalizeNextButton()
        }
        else -> {
            activity?.actionBar?.title = "캐릭터 선택"
            setAttributeName()
            view.findNavController().navigate(R.id.game)
        }
    }
    private fun setAttributeDrawable(resName: String){
        val share = Login()
        context?.let {
            share.removeAttribute(it, "resName")
            share.setAttribute(it, "resName", resName)
        }
    }
    private fun setAttributeName(){
        val share = Login()
        context?.let {
            share.setAttribute(it,"userName",binding.editText.text.toString())
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

    private fun vitalizeNextButton() {
        if (checkChooseCharacter() && binding.editText.text.toString() != "") {
            binding.btnNext.isEnabled = true
            return
        }
        binding.btnNext.isEnabled = false
    }

}