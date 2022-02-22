package com.example.kotlin_cardgame

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.widget.addTextChangedListener
import com.example.kotlin_cardgame.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setImageButtonSize()

        binding.nicknameEditText.addTextChangedListener {
            val isClickable: Boolean = isNicknameAble(binding.nicknameEditText.text.toString())
            setEmotionButtonEnable(isClickable)

        }
    }

    private fun isNicknameAble(text: String): Boolean {
        // 제외사항
        // 빈칸일경우
        // 5자가 넘을 경우
        // 공백이나 특수문자가 있을 경우
        // 숫자만 있을경우
        // 알파벳이 한글자라도 포함 되지 않는경우

        return if (text.isEmpty() || text.length > 5) false
        else if (text.any { !it.isLetterOrDigit() }) false
        else if (text.all { it.isDigit() }) false
        else !text.none { it in 'a'..'z' || it in 'A'..'Z' }
    }


    private fun setImageButtonSize() {

        val viewDrawingListener = object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                Log.d(TAG, binding.smileImageButton.width.toString())
                binding.smileImageButton.layoutParams.height = binding.smileImageButton.width
                binding.smileImageButton.requestLayout()
                binding.smileImageButton.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        }
        binding.smileImageButton.viewTreeObserver.addOnGlobalLayoutListener(viewDrawingListener)
    }


    private fun setEmotionButtonEnable(isClickable: Boolean) {
        binding.smileImageButton.isEnabled = isClickable
        binding.neutralImageButton.isEnabled = isClickable
        binding.dissatisfiedImageButton.isEnabled = isClickable
        binding.badImageButton.isEnabled = isClickable
    }
}




